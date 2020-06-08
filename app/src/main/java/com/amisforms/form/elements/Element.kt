package com.amisforms.form.elements

import com.amisforms.form.asserts.BaseAssert

open class Element
{
    protected val assertionsArray = mutableListOf<BaseAssert>()
    protected var hasError = false

    var currentErrorMessage = ""

    open fun validate(): Boolean {
        hasError = false
        return hasError
    }

    open fun pushAssertion(assert: BaseAssert): Element
    {
        assertionsArray.add(assert)
        return this
    }

    open fun checkHasError()
    {
        return
    }
}