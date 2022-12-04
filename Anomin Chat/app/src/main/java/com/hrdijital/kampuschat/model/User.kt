package com.hrdijital.kampuschat.model

import android.net.Uri

data class User(var mail:String?,
                var userName:String?,
                var password:String?,
                var description:String?,
                var dataPicker:String?,
                var gender:String?,
                var uri:Uri?,
                var downloadUrl:String?)