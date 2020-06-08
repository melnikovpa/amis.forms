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

    private var label: TextView? = null
    private var errorLayout: LinearLayout? = null

    var edit: InputElement? = null
    var error: TextView? = null

    init {
        this.label = layout.findViewById(R.id.txtCompositeItemLabel)
        this.errorLayout = layout.findViewById(R.id.llCompositeItemError)
        this.error = layout.findViewById(R.id.txtCompositeItemError)

        currentId = _layout.id

        val editText: EditText = layout.findViewById(R.id.edtCompositeEditText)
        this.edit = InputElement(
            editText, container,
            errorOnInput = false,
            clearValidationWhenEmpty = _layout.clearValidationWhenEmpty
        )

        checkHasError()
    }

    override fun pushAssertion(assert: BaseAssert): Element
    {
        this.edit!!.pushAssertion(assert)
        return this
    }

    override fun valid(): Boolean
    {
        super.valid()
        hasError = this.edit!!.valid()
        if(hasError) {
            this.error?.text = this.edit!!.currentErrorMessage
            errorLayout?.visibility = View.VISIBLE
            hasError = true
        }

        checkHasError()
        return hasError
    }

    override fun checkHasError()
    {
        if (!hasError) {
            error?.text = "";
            errorLayout?.visibility = View.GONE
        }
    }


}