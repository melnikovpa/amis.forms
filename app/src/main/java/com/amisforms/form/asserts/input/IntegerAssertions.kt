package com.amisforms.form.asserts.input

import android.widget.EditText
import com.amisforms.form.asserts.BaseAssert

class IntegerAssertions(
    errorMessage: String
) : BaseAssert()
{
    init {
        this.setErrorMessage(errorMessage)
    }

    override fun invalid(input: EditText): Boolean
    {
        val str  = input.text.toString()
        val cast = str.toIntOrNull()

        return cast == null
    }
}