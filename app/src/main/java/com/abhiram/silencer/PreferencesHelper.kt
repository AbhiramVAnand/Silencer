package com.abhiram.silencer

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(
    private val appContext : Application
) {
    var sharedPrefences : SharedPreferences
    var editor : SharedPreferences.Editor

    val IS_SILENT = "isSilent"

    init {
        sharedPrefences = appContext.getSharedPreferences("my_app_prefs", Context.MODE_PRIVATE)
        editor = sharedPrefences.edit()
    }

    fun setIsSilent(isSilent : Boolean){
        editor.putBoolean(IS_SILENT,isSilent).apply()
    }

    fun getIsSilent() : Boolean{
        return sharedPrefences.getBoolean(IS_SILENT,false)
    }
}