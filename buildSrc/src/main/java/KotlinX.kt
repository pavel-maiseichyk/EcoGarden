object DataStore {

    private const val dataStoreVersion = "1.0.0"
    const val dataStore = "androidx.datastore:datastore:$dataStoreVersion"
    const val dataStorePreferences = "androidx.datastore:datastore-preferences:$dataStoreVersion"


    // Jetpack DataStore
    implementation "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
    implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3"
}