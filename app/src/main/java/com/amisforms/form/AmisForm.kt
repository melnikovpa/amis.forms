package com.amisforms.form

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.amisforms.form.validation.DestroyLifecycleObserver
import com.amisforms.form.validation.ValidationContainer

/**
 * Constructs a validation form for an FragmentActivity (which includes AppCompatActivity).
 */
fun FragmentActivity.amisForm(builder: FormBuilder): Form {
    val activity = this
    val container = object : ValidationContainer(activity) {
        override fun <T : View> findViewById(id: Int): T? = activity.findViewById(id)
    }
    return Form(container)
        .apply(builder)
        .also { lifecycle.addObserver(DestroyLifecycleObserver(it)) }
        .start()
}

/**
 * Constructs a validation form for a Fragment.
 */
fun Fragment.amisForm(builder: FormBuilder): Form {
    val activity = this.activity ?: throw IllegalStateException("Fragment is not attached.")
    val container = object : ValidationContainer(activity) {
        override fun <T : View> findViewById(id: Int): T? = view?.findViewById(id)
    }
    return Form(container)
        .apply(builder)
        .also { lifecycle.addObserver(DestroyLifecycleObserver(it)) }
        .start()
}