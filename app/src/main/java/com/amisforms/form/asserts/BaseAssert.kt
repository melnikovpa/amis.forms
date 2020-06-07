package com.amisforms.form.asserts

import android.widget.CompoundButton
import android.widget.EditText
import com.amisforms.form.validation.ValidationContainer

open class BaseAssert
{
    private var errorMessage = "Недопустимое значение"
    private var _container: ValidationContainer? = null

    fun setContainer(container: ValidationContainer)
    {
        _container = container
    }

    fun getErrorMessage() : String
    {
        return this.errorMessage;
    }

    fun setErrorMessage(error: String)
    {
        this.errorMessage = error
    }

    open fun check(input: EditText): Boolean
    {
        return true
    }

    open fun check(input: CompoundButton): Boolean
    {
        return !input.isChecked
    }
}