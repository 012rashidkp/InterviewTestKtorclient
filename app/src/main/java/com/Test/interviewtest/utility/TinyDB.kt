package com.Test.interviewtest.utility

import android.content.Context
import android.content.SharedPreferences
import com.Test.interviewtest.domain.model.FetchMovieList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TinyDB(val context: Context) {
    private val PREFS_NAME = "kotlincodes"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun putmovieitems(key: String?, model_: FetchMovieList?) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        val gson = Gson()
        val json = gson.toJson(model_)
        editor.putString(key, json)
        editor.apply()
    }
    fun getmovieitems(key: String?): FetchMovieList? {
        val gson = Gson()
        val json: String = sharedPref.getString(key, null)!!
        val type_ = object : TypeToken<ArrayList<FetchMovieList?>?>() {}.type
        return gson.fromJson(json, type_)
    }


}