package com.hrdijital.kampuschat.model

import android.view.View

data class Message(
    var mesaj:String?,
    var sender:String?,
    var received:String?

){


    fun senderVisibility():Int{

        if (sender=="turan"){

            return View.VISIBLE

        }
        else{

            return View.GONE
        }
    }

    fun receivedVisibility():Int{

        if (sender=="turan"){

            return View.GONE

        }
        else{

            return View.VISIBLE
        }
    }

}
