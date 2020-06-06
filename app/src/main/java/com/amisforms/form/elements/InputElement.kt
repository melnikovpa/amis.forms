package com.amisforms.form.elements

import com.amisforms.form.asserts.BaseAssert

open class InputElement
{
    protected val assertionsArray = mutableListOf<BaseAssert>()

    fun pushAssertion(assert: BaseAssert)
    {
        assertionsArray.add(assert)
    }
}