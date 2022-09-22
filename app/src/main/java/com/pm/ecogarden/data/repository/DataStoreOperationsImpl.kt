package com.pm.ecogarden.auth.auth_one_click.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.pm.ecogarden.auth.auth_one_click.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException

class DataStoreOperationsImpl(
    private val dataStore: DataStore<Preferences>
) : DataStoreOperations {

    private object PreferencesKey {
        val signedInKey = booleanPreferencesKey("signed_in_key ")
    }

    override suspend fun saveSignedInState(isSignedIn: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKey.signedInKey] = isSignedIn
        }
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.data
            .catch { e ->
                if (e is IOException)
                    emit(emptyPreferences())
                else throw e
            }
            .map { prefs ->
                val isSignedIn = prefs[PreferencesKey.signedInKey] ?: false
                isSignedIn
            }
    }
}