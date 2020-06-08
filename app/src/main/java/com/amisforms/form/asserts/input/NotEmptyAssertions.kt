package com.amisforms.form.asserts.input

import android.widget.EditText
import com.amisforms.form.asserts.BaseAssert

class NotEmptyAssertions(
    errorMessage: String
) : BaseAssert()
{
    init {
        this.setErrorMessage(errorMessage)
    }

    override fun invalid(input: EditText): Boolean
    {
        return input.text.isBlank()
    }
}