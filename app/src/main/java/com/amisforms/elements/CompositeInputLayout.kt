package com.amisforms.elements

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.amisforms.R

class CompositeInputLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs)
{
    private fun init(context: Context, attrs: AttributeSet)
    {
        View.inflate(context, R.layout.input_layout_composite, this)
    }

    init {
        init(context, attrs)
    }
}