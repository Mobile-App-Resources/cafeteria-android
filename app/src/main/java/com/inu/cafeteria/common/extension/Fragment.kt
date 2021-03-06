/**
 * Copyright (C) 2018-2019 INU Appcenter. All rights reserved.
 *
 * This file is part of INU Cafeteria.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */

package com.inu.cafeteria.common.extension

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelProviders
import com.inu.cafeteria.extension.withNonNull
import com.inu.cafeteria.util.Notify
import kotlinx.android.synthetic.main.single_fragment_activity.*

/**
 * Do something in the middle of beginTransaction() and commit().
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

/**
 * Do something in the middle of beginTransaction() and commitNow().
 */
inline fun FragmentManager.inImmediateTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitNow()
}


/**
 * Show only one fragment.
 */
inline fun FragmentManager.showOnly(predicate: (Fragment) -> Boolean): Boolean  {
    inTransaction {
        fragments.forEach {
            if (predicate(it)) {
                show(it)
            }
            else {
                hide(it)
            }
        }
        this
    }

    executePendingTransactions()

    return true
}

/**
 * Add multiple fragments. (Collection)
 */
fun FragmentTransaction.addAll(@IdRes containerViewId: Int, fragments: Collection<Fragment>) {
    fragments.forEach {
        add(containerViewId, it)
    }
}

/**
 * Add multiple fragments. (Array)
 */
fun FragmentTransaction.addAll(@IdRes containerViewId: Int, fragments: Array<out Fragment>) {
    fragments.forEach {
        add(containerViewId, it)
    }
}

/**
 * Get ViewModel of the fragment with SingleUseCaseViewModelFactory.
 */
inline fun <reified T : ViewModel> Fragment.getViewModel(factory: Factory, body: T.() -> Unit = {}): T {
    return ViewModelProviders.of(this, factory).get(T::class.java).apply(body)
}

/**
 * Get ViewModel of the fragment without SingleUseCaseViewModelFactory.
 */
inline fun <reified T : ViewModel> Fragment.getViewModel(body: T.() -> Unit = {}): T {
    return ViewModelProviders.of(this).get(T::class.java).apply(body)
}

/**
 * For Activity.
 * Get ViewModel of the fragment with SingleUseCaseViewModelFactory.
 */
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: Factory, body: T.() -> Unit = {}): T {
    return ViewModelProviders.of(this, factory).get(T::class.java).apply(body)
}

/**
 * For Activity
 * Get ViewModel of the fragment without SingleUseCaseViewModelFactory.
 */
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(body: T.() -> Unit = {}): T {
    return ViewModelProviders.of(this).get(T::class.java).apply(body)
}

val Fragment.baseActivity: AppCompatActivity? get() = (activity as? AppCompatActivity)
val Fragment.viewContainer: View? get() = (activity as? AppCompatActivity)?.fragment_container
val Fragment.appContext: Context get() = activity?.applicationContext!!

val Fragment.supportActionBar: ActionBar? get() = (activity as? AppCompatActivity)?.supportActionBar

fun Fragment.setSupportActionBar(toolbar: Toolbar, title: Boolean = false, upButton: Boolean = false) {
    withNonNull(activity as? AppCompatActivity) {
        setSupportActionBar(toolbar)

        withNonNull(supportActionBar) {
            setDisplayShowTitleEnabled(title)
            setDisplayHomeAsUpEnabled(upButton)
        }
    }
}

fun Fragment.notify(message: String?, long: Boolean = false) {
    message?.let {
        with(Notify(context)) {
            if (long) long(it) else short(it)
        }
    }
}

fun Fragment.finishActivity() {
    activity?.finish()
}

fun Fragment.hideKeyboard() {
    baseActivity?.hideKeyboard()
}