package com.amisforms.form.elements

import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.amisforms.form.asserts.BaseAssert
import com.amisforms.form.validation.ValidationContainer

class CheckElement constructor(
    view: View,
    container: ValidationContainer
): Element()
{
    private var _container: ValidationContainer = container
    var item: CompoundButton? = null

    init {
        item = view as CompoundButton
        currentId = item!!.id
    }

    fun onCheckChange(onCheckChange: (buttonView: CompoundButton, isChecked: Boolean) -> Unit): CheckElement
    {
        item!!.setOnCheckedChangeListener { buttonView, isChecked ->  onCheckChange(buttonView, isChecked)}
        return this
    }

    override fun valid() : Boolean
    {
        super.valid()

        for (assert in assertionsArray) {
            if (hasError) {
                break
            }

            assert.setContainer(container = _container)
            hasError = assert.invalid(this.item!!)
        }

        return hasError
    }
}