package com.example.appnews.commons.preference

import android.content.Context
import android.content.SharedPreferences
import com.example.appnews.utils.ConstansKotlin.Companion.keyPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceModule @Inject constructor(@ApplicationContext context: Context) {

    private val preference: SharedPreferences =
        context.getSharedPreferences(keyPreference, Context.MODE_PRIVATE)


    fun setStrings(key: String, value: String) {
        val editor = preference.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStrings(key: String): String {
        return preference.getString(key, "").toString()
    }

    fun deleteString(key: String) {
        preference.getString(key, "")
        preference.edit().clear().apply()
    }

    fun setBoolean(key: String, value: Boolean) {
        val editor = preference.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean {
        return preference.getBoolean(key, false)
    }

    fun setInteger(key: String, value: Int) {
        val editor = preference.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInteger(key: String): Int {
        return preference.getInt(key, 0)
    }

    fun deleteBoolean(key: String) {
        preference.getBoolean(key, false)
        preference.edit().clear().apply()
    }

}