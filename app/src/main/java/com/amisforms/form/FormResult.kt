package com.amisforms.form

import com.amisforms.form.elements.Element

class FormResult
{
    /** id элемента, сам элемент, текущий текст ошибки*/
    private var errorsStack: HashMap<Int, Element> = HashMap()

    fun putError(element: Element)
    {
        errorsStack[element.currentId] = element
    }

    fun success(): Boolean
    {
        return errorsStack.isEmpty()
    }

}