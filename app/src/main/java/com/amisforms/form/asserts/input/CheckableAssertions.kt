package com.amisforms.form.asserts.input

import android.widget.CompoundButton
import com.amisforms.form.asserts.BaseAssert

class CheckableAssertions(
    errorMessage: String
) : BaseAssert()
{
    init {
        this.setErrorMessage(errorMessage)
    }

    override fun invalid(input: CompoundButton): Boolean
    {
        return !input.isChecked
    }
}