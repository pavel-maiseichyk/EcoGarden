package com.pm.ecogarden.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.pm.ecogarden.data.local.EcoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBlockDatabase(app: Application): EcoDatabase {
        return Room.databaseBuilder(
            app,
            EcoDatabase::class.java,
            EcoDatabase.DATABASE_NAME
        )
       //     .createFromAsset("database/empty_block_field.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideDataStore(
        app: Application,
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { app.preferencesDataStoreFile("auth_preferences") }
        )
    }
}