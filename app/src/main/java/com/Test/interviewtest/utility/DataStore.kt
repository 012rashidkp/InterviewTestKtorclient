package com.Test.interviewtest.utility

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
class DataStore(private val context: Context) {
    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("storedata")
        val ID = stringPreferencesKey("trip_status")
        val TITLE= stringPreferencesKey("till_status")
        val DESC= stringPreferencesKey("ticket_number")
        val RELEASE= stringPreferencesKey("release")
        val POSTERURL= stringPreferencesKey("posterurl")
        val RATING= stringPreferencesKey("rating")
        val GENRE_LIST = stringSetPreferencesKey("genre_list")
    }

    suspend fun Saveid(id:String?) {
        context.dataStore.edit { preferences ->
            preferences[ID] = id?:""
        }
    }

    var getid: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[ID] ?: ""
        }


    suspend fun Savetitle(title:String?) {
        context.dataStore.edit { preferences ->
            preferences[TITLE] = title?:""
        }
    }

    var getTitle: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[TITLE] ?: ""
        }

    suspend fun Savedesc(desc:String?) {
        context.dataStore.edit { preferences ->
            preferences[DESC] = desc?:""
        }
    }

    var getdesc: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[DESC] ?: ""
        }

    suspend fun Saverelease(release:String?) {
        context.dataStore.edit { preferences ->
            preferences[RELEASE] = release?:""
        }
    }

    var getrelease: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[RELEASE] ?: ""
        }

    suspend fun Saveposterurl(posterurl:String?) {
        context.dataStore.edit { preferences ->
            preferences[POSTERURL] = posterurl?:""
        }
    }

    var getposterurl: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[POSTERURL] ?: ""
        }

    suspend fun Saverating(rating:String?) {
        context.dataStore.edit { preferences ->
            preferences[RATING] = rating?:""
        }
    }

    var getrating: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[RATING] ?: ""
        }








    suspend fun Savegeneres(generes:List<String>?) {
        context.dataStore.edit { preferences ->
            preferences[GENRE_LIST] = generes?.toSet()?: emptySet()
        }
    }

    var getgeneres: Flow<List<String>?> = context.dataStore.data
        .map { preferences ->
            preferences[GENRE_LIST]?.toList()?: emptyList()
        }










}