package com.amisforms.form.validation

import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.amisforms.form.Form

/**
 * Attaches to a Lifecycle and destroys the given Form when the
 * Lifecycle owner is being destroyed.
 */
class DestroyLifecycleObserver(
    private val form: Form
) : LifecycleObserver {

    @OnLifecycleEvent(ON_DESTROY)
    fun onDestroy() = form.destroy()
}