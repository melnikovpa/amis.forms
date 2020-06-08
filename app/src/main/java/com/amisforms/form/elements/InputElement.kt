package com.amisforms.form.elements

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import com.amisforms.form.validation.ValidationContainer

class InputElement constructor(
    view: View,
    container: ValidationContainer,
    errorOnInput: Boolean = true,
    clearValidationWhenEmpty: Boolean = false
): Element()
{
    private var _container: ValidationContainer = container
    private var _errorOnInput: Boolean = errorOnInput
    private var _clearValidationWhenEmpty = clearValidationWhenEmpty

    var edit: EditText? = null

    init {
        edit = view as EditText
        currentId = edit!!.id
        realTimeValidation()
    }

    fun clearValidationWhenEmpty(clear: Boolean = true) : InputElement
    {
        this._clearValidationWhenEmpty = clear
        return this
    }

    override fun valid(): Boolean
    {
        super.valid()

        for (assert in assertionsArray) {
            if (hasError) {
                break
            }

            assert.setContainer(container = _container)

            hasError = assert.invalid(this.edit!!)
            this.currentErrorMessage = assert.getErrorMessage()

            if (hasError && _errorOnInput) {
                this.edit!!.error = this.currentErrorMessage
            }
        }

        checkHasError()
        return hasError
    }

    override fun checkHasError()
    {
        if (!hasError) {
            this.currentErrorMessage = ""
            this.edit!!.error = null
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

                if (_clearValidationWhenEmpty && edit!!.text.isEmpty()) {
                    hasError = false
                    checkHasError()
                    return
                }

                valid()
            }
        })
    }
}