package com.amisforms.form.elements

import com.amisforms.form.asserts.BaseAssert

open class Element
{
    protected val assertionsArray = mutableListOf<BaseAssert>()
    protected var hasError = false

    open fun validate() {
        hasError = false
    }

    fun pushAssertion(assert: BaseAssert): Element
    {
        assertionsArray.add(assert)
        return this
    }
}