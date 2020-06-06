package com.amisforms.form.asserts

import android.widget.EditText

open class BaseAssert
{
    private var errorMessage = "Недопустимое значение"

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
}