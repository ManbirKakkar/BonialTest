package io.bonial.test.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity?.showToast(msg: String, ) {
    this?.let {
        Toast.makeText(it, msg, Toast.LENGTH_SHORT).show()
    }
}

fun View.toggleVisibleGone(isVisible: Boolean) {
    this.visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}