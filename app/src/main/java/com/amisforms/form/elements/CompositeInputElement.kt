package com.amisforms.form.elements

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.amisforms.R
import com.amisforms.elements.CompositeInputLayout
import com.amisforms.form.asserts.BaseAssert
import com.amisforms.form.validation.ValidationContainer

class CompositeInputElement constructor(
    layout: CompositeInputLayout,
    container: ValidationContainer
): Element()
{
    private var _container: ValidationContainer = container
    private var _layout: CompositeInputLayout = layout

    var label: TextView? = null
    var edit: EditText? = null

    var errorLayout: LinearLayout? = null
    var error: TextView? = null

    init {
        this.label = layout.findViewById(R.id.txtCompositeItemLabel)
        this.edit  = layout.findViewById(R.id.edtCompositeEditText)
        this.errorLayout = layout.findViewById(R.id.llCompositeItemError)
        this.error = layout.findViewById(R.id.txtCompositeItemError)

        checkHasError()
        realTimeValidation()
    }

//    fun pushAssertion(assert: BaseAssert): CompositeInputElement
//    {
//        assertionsArray.add(assert)
//        return this
//    }

    override fun validate()
    {
        super.validate()

        for (assert in assertionsArray) {
            if (hasError) {
                break
            }

            assert.setContainer(container = _container)

            val result: Boolean = assert.check(this.edit!!)

            if(!result) {
                this.error?.text = assert.getErrorMessage()
                this.error?.setError("dasdasd", null)
                errorLayout?.visibility = View.VISIBLE
                hasError = true
            }
        }

        checkHasError()
    }

    fun checkHasError()
    {
        if (!hasError) {
            error?.text = "";
            errorLayout?.visibility = View.GONE
        }
    }

    fun realTimeValidation()
    {
        this.edit!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (_layout.clearValidationWhenEmpty && edit!!.text.isEmpty()) {
                    hasError = false
                    checkHasError()
                    return
                }

                validate()
            }
        })
    }
}