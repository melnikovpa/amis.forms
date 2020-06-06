package com.amisforms.form.elements

import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.amisforms.R
import com.amisforms.elements.CompositeInputLayout

class CompositeInputElement constructor(
    layout: CompositeInputLayout
): InputElement()
{
    var label: TextView? = null
    var edit: EditText? = null

    var errorLayout: LinearLayout? = null
    var error: TextView? = null

    init {
        this.label = layout.findViewById(R.id.txtCompositeItemLabel)
        this.edit  = layout.findViewById(R.id.edtCompositeEditText)
        this.errorLayout = layout.findViewById(R.id.llCompositeItemError)
        this.error = layout.findViewById(R.id.txtCompositeItemError)

        this.label!!.text = "!!!asdasdasdasdads"
    }

    fun validate()
    {
        for (assert in assertionsArray) {
            val result: Boolean = assert.check(this.edit!!)

            if(!result) {
                this.error?.text = assert.getErrorMessage()
            }
        }
    }
}