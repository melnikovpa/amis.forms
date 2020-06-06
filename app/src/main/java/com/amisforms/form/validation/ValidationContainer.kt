package com.amisforms.form.validation

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes

abstract class ValidationContainer(private val context: Context) {

    abstract fun <T : View> findViewById(@IdRes id: Int): T?

    internal fun getString(@StringRes res: Int?): String? {
        return if (res == null) {
            null
        } else {
            context.getString(res)
        }
    }

    internal fun getFieldName(@IdRes id: Int): String {
        if (id == 0) return "(no ID)"
        val res = context.resources
        return res.getResourceEntryName(id)
    }
}

fun <T : View> ValidationContainer?.getViewOrThrow(@IdRes id: Int): T {
    if (this == null) {
        throw IllegalStateException("Form has been destroyed.")
    }
    return findViewById(id) ?: throw IllegalStateException(
        "Unable to find a view by ID ${getFieldName(id)} in the container."
    )
}

fun ValidationContainer?.checkAttached(): ValidationContainer {
    if (this == null) {
        throw IllegalStateException("Not attached, form has been destroyed.")
    }
    return this
}