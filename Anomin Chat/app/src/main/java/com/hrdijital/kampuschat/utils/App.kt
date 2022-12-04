package com.hrdijital.kampuschat.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.widget.LinearLayout

import android.widget.TextView
import com.hrdijital.kampuschat.model.User


class App: Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var manager: PreferencesManager? = null
        @SuppressLint("StaticFieldLeak")
        lateinit var toolbar: androidx.appcompat.widget.Toolbar
        @SuppressLint("StaticFieldLeak")
        lateinit var logo: LinearLayout
        @SuppressLint("StaticFieldLeak")
        lateinit var user:User


        // lateinit var toolbar_history: ImageView

        fun toolbar_desing(navigation_icon:Int?,
                           toolbar_color:Int,
                           toolbar_texts:String,
                           toolbar_text_color:Int,
                           status_bar_color:Int,
                           status_bar_mode:Int,
                           context:Activity,
                           toolbar_visibility:Int,
                           logoVisibility:Int
        ):androidx.appcompat.widget.Toolbar{

            context.window.decorView.systemUiVisibility = status_bar_mode
            context.window.statusBarColor= status_bar_color
            toolbar.visibility=toolbar_visibility
            toolbar.setBackgroundColor(toolbar_color)
            navigation_icon?.let { toolbar.setNavigationIcon(it) };
            return toolbar
        }


    }
    override fun onCreate() {
        super.onCreate()
        manager = PreferencesManager(this)

    }

}