package com.hrdijital.kampuschat.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences



class PreferencesManager @SuppressLint("CommitPrefEdits")
constructor(context: Context) {

    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences(PREFERENCE_CONFIGURATION_NAME,Context.MODE_PRIVATE)
        editor = preferences.edit()
    }
    fun getIsFirstRun() = preferences.getBoolean(IS_FIRST_RUN, true)

    fun setIsFirstRun(isFirstRun: Boolean) {
        editor.putBoolean(IS_FIRST_RUN, isFirstRun).commit()
        editor.commit()
    }
    fun getLoginState() = preferences.getBoolean(IS_LOGIN, false)

    fun setLoginState(loginState: Boolean) {
        editor.putBoolean(IS_LOGIN, loginState).commit()
        editor.commit()
    }

    fun getUserId() = preferences.getString(USER_ID, "").toString()

    fun setUserId(userId: String) {
        editor.putString(USER_ID, userId).commit()
        editor.commit()
    }

    fun getDistance() = preferences.getString(DISTANCE, "1000").toString()

    fun setDistance(userId: String) {
        editor.putString(DISTANCE, userId).commit()
        editor.commit()
    }

    fun getUser() = preferences.getString(Name, "").toString()

    fun setUser(name: String) {
        editor.putString(Name, name).commit()
        editor.commit()
    }


    fun getPhoneNumber() = preferences.getString(PHONE_NUMBER, "").toString()

    fun setPhoneNumber(phoneNumber: String) {
        editor.putString(PHONE_NUMBER, phoneNumber).commit()
        editor.commit()
    }
    fun getCity() = preferences.getString(City, "").toString()

    fun setCity(city: String) {
        editor.putString(City, city).commit()
        editor.commit()
    }

    fun getLastLocationLat() = preferences.getString(LAST_LOCATION_LAT, "0.0").toString()

    fun setLastLocationLat(lat: String) {
        editor.putString(LAST_LOCATION_LAT, lat).commit()
        editor.commit()
    }

    fun getLastLocationLong() = preferences.getString(LAST_LOCATION_LONG, "0.0").toString()

    fun setLastLocationLong(long: String) {
        editor.putString(LAST_LOCATION_LONG, long).commit()
        editor.commit()
    }




    fun setMail(url: String?) {
        editor.putString(Mail, url).commit()
        editor.commit()
    }

    fun getMail() = preferences.getString(Mail, "").toString()

    fun setSurname(surname: String) {
        editor.putString(Surname, surname).commit()
        editor.commit()
    }
    fun getSurname() = preferences.getString(Surname, "").toString()


    fun remove() {


        editor.remove("isfirstrun").apply()
        editor.remove("login_state").apply()
        editor.remove("distance").apply()
        editor.remove("server_url").apply()
        editor.remove("operatorname").apply()
        editor.remove("Fcm_token").apply()
        editor.remove("phonenumber").apply()
        editor.remove("lastlocationlat").apply()
        editor.remove("lastlocationlong").apply()
        editor.remove("extra").apply()


    }
    companion object {
        private const val PRIVATE_MODE = 0
        private const val PREFERENCE_CONFIGURATION_NAME = "configuration"
        private const val USER_ID = "userid"
        private const val IS_FIRST_RUN = "isfirstrun"
        private const val IS_LOGIN = "login_state"
        private const val DISTANCE = "distance"
        private const val Mail = "mail"
        private const val Name = "name"
        private const val Surname = "surname"
        private const val PHONE_NUMBER = "phonenumber"
        private const val LAST_LOCATION_LAT = "lastlocationlat"
        private const val LAST_LOCATION_LONG = "lastlocationlong"

        private const val City = "city"

    }
}