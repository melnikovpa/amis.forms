package com.amisforms.elements

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import com.amisforms.R

class CompositeRadioGroup(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs)
{
    private var firstControlLabel: TextView? = null
    private var secondControlLabel: TextView? = null
    private var radioGroup: RadioGroup? = null;

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.radio_group_composite, this)
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CompositeRadioGroup)
        val firstControlLabel  = typedArray.getText(R.styleable.CompositeRadioGroup_first_control_label)
        val secondControlLabel = typedArray.getText(R.styleable.CompositeRadioGroup_second_control_label)

        typedArray.recycle()
        initComponents()

        this.firstControlLabel!!.text = firstControlLabel.toString()
        this.secondControlLabel!!.text = secondControlLabel.toString()
    }

    fun getRadioGroup(): RadioGroup?
    {
        return this.radioGroup
    }

    private fun initComponents() {
        radioGroup = findViewById<View>(R.id.tab_button_radio_group) as RadioGroup
        firstControlLabel = findViewById<View>(R.id.first_control_label) as TextView
        secondControlLabel = findViewById<View>(R.id.second_control_label) as TextView
    }

    init {
        init(context, attrs)
    }
}