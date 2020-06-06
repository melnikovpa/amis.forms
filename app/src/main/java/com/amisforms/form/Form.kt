package com.amisforms.form

import android.view.View
import android.widget.TextView
import com.amisforms.R
import com.amisforms.elements.CompositeInputLayout
import com.amisforms.form.elements.CompositeInputElement
import com.amisforms.form.validation.ValidationContainer

typealias FormBuilder = Form.() -> Unit

class Form constructor(validationContainer: ValidationContainer)
{
    var container: ValidationContainer? = validationContainer

    //private val fields = mutableListOf<GenericFormField>()

    fun compositeInput(
        view: CompositeInputLayout
    ) : CompositeInputElement {

        val element = CompositeInputElement(
            layout = view
        )

//        val txtCompositeItemLabel = view.findViewById<TextView>(R.id.txtCompositeItemLabel)
//
//        txtCompositeItemLabel.text = "sadsadsadsadasd"

        return element
    }

    fun submitWith(
        view: View,
        onSubmit: () -> Unit
    ) = view.setOnClickListener {
        //val result = validate()
        //if (result.success()) {
        onSubmit()
        //}
    }

    fun start(): Form {
        return this
    }

    internal fun destroy() {
        //fields.clear()
        container = null
    }
}