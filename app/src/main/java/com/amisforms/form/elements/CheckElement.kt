package com.amisforms.form.elements

import android.view.View
import com.amisforms.form.asserts.BaseAssert

class CheckElement constructor(
    view: View
): InputElement()
{
    fun pushAssertion(assert: BaseAssert): CheckElement
    {
        assertionsArray.add(assert)
        return this
    }
}