package com.amisforms.form.elements

import android.widget.TextView
import com.amisforms.R
import com.amisforms.elements.CompositeInputLayout

class CompositeInputElement internal  constructor(
    layout: CompositeInputLayout
): InputElement()
{
    var label: TextView? = null

    init {
        this.label = layout.findViewById(R.id.txtCompositeItemLabel)
    }

    fun isNotBlank()
    {

    }
}