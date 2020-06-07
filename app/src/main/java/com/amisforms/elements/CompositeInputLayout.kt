package com.amisforms.elements

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.amisforms.R

class CompositeInputLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs)
{
    private var orientation: String = "vertical"
    public var clearValidationWhenEmpty: Boolean = false

    private fun init(context: Context, attrs: AttributeSet)
    {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CompositeInputLayout)
        orientation = typedArray.getText(R.styleable.CompositeInputLayout_orientation).toString()
        clearValidationWhenEmpty = typedArray.getBoolean(R.styleable.CompositeInputLayout_clearValidationWhenEmpty, false)
        typedArray.recycle()

        if (orientation == "vertical") {
            View.inflate(context, R.layout.input_layout_composite, this)
        } else {
            View.inflate(context, R.layout.input_layout_composite_horisontal, this)
        }
    }

    init {
        init(context, attrs)
    }
}