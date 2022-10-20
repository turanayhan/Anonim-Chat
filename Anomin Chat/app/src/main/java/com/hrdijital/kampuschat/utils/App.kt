package com.hrdijital.kampuschat.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application

import android.widget.TextView



class App: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var manager: PreferencesManager? = null
        @SuppressLint("StaticFieldLeak")
        lateinit var toolbar: androidx.appcompat.widget.Toolbar
        lateinit var toolbar_text: TextView

        // lateinit var toolbar_history: ImageView

        fun toolbar_desing(navigation_icon:Int,
                           toolbar_color:Int,
                           toolbar_texts:String,
                           toolbar_text_color:Int,
                           status_bar_color:Int,
                           status_bar_mode:Int,
                           context:Activity,
                           toolbar_visibility:Int,
        ):androidx.appcompat.widget.Toolbar{

            context.window.decorView.systemUiVisibility = status_bar_mode
            context.window.statusBarColor= status_bar_color
            toolbar.visibility=toolbar_visibility
            toolbar.setBackgroundColor(toolbar_color)
            toolbar.setNavigationIcon(navigation_icon);
            toolbar_text.setTextColor(toolbar_text_color)
            toolbar_text.setText(toolbar_texts)
            return toolbar
        }


    }
    override fun onCreate() {
        super.onCreate()
        manager = PreferencesManager(this)

    }

}