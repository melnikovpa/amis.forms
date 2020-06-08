package com.amisforms.form

import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import com.amisforms.R
import com.amisforms.elements.CompositeInputLayout
import com.amisforms.form.elements.CheckElement
import com.amisforms.form.elements.CompositeInputElement
import com.amisforms.form.elements.Element
import com.amisforms.form.elements.InputElement
import com.amisforms.form.validation.ValidationContainer

typealias FormBuilder = Form.() -> Unit

class Form constructor(validationContainer: ValidationContainer)
{
    var container: ValidationContainer? = validationContainer

    private val compositeFields = mutableListOf<Element>()

    fun input(view: EditText): InputElement
    {
        val element = InputElement(
            view = view,
            container = container!!
        )

        compositeFields.add(element)
        return element
    }

    fun checkable(
        view: CompoundButton
    ) : CheckElement {
        val element = CheckElement(
            view = view,
            container = container!!
        )

        compositeFields.add(element = element)
        return element
    }

    fun compositeInput(
        view: CompositeInputLayout
    ) : CompositeInputElement {
        val element = CompositeInputElement(
            layout = view,
            container = container!!
        )

        compositeFields.add(element = element)
        return element
    }

    fun submitWith(
        view: View,
        onSubmit: () -> Unit
    ) = view.setOnClickListener {
        validate()
        //val result = validate()
        //if (result.success()) {
        onSubmit()
        //}
    }

    private fun validate()
    {
        for (composite in compositeFields) {
            composite.validate()
        }
    }

    fun start(): Form {
        return this
    }

    internal fun destroy() {
        //fields.clear()
        container = null
    }
}