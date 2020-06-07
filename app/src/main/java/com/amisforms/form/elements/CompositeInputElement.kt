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

class CompositeInputElement constructor(
    layout: CompositeInputLayout
): InputElement()
{
    var label: TextView? = null
    var edit: EditText? = null

    var errorLayout: LinearLayout? = null
    var error: TextView? = null

    private var hasError = false

    init {
        this.label = layout.findViewById(R.id.txtCompositeItemLabel)
        this.edit  = layout.findViewById(R.id.edtCompositeEditText)
        this.errorLayout = layout.findViewById(R.id.llCompositeItemError)
        this.error = layout.findViewById(R.id.txtCompositeItemError)

        checkHasError()
        realTimeValidation()
    }

    fun pushAssertion(assert: BaseAssert): CompositeInputElement
    {
        assertionsArray.add(assert)
        return this
    }

    fun validate()
    {
        hasError = false

        for (assert in assertionsArray) {
            if (hasError) {
                break
            }

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
                validate()
            }
        })
    }
}