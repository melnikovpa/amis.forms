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
    }

    fun onCheckChange(onCheckChange: (buttonView: CompoundButton, isChecked: Boolean) -> Unit): CheckElement
    {
        item!!.setOnCheckedChangeListener { buttonView, isChecked ->  onCheckChange(buttonView, isChecked)}
        return this
    }

//    fun pushAssertion(assert: BaseAssert): CheckElement
//    {
//        assertionsArray.add(assert)
//        return this
//    }

    override fun validate() {
        super.validate()

        for (assert in assertionsArray) {
            if (hasError) {
                break
            }

            assert.setContainer(container = _container)
            val result: Boolean = assert.check(this.item!!)
            if (!result) {
                hasError = true
            }
        }
    }
}