package com.amisforms.form.asserts.input

import android.widget.EditText
import com.amisforms.form.asserts.BaseAssert

class NotEmptyAssertions : BaseAssert()
{

    override fun check(input: EditText): Boolean
    {
        return !input.text.isBlank()
    }
}