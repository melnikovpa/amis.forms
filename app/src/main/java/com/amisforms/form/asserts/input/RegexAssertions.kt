package com.amisforms.form.asserts.input

import android.widget.EditText
import com.amisforms.form.asserts.BaseAssert

class RegexAssertions(
    errorMessage: String,
    regexValue: String
): BaseAssert()
{
    private var _regexValue: String = ""

    init {
        this.setErrorMessage(errorMessage)
        _regexValue = regexValue
    }

    override fun invalid(input: EditText): Boolean
    {
        return !_regexValue.toRegex().matches(input.text)
    }
}