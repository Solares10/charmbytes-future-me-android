package com.charmbytes.futureme
import android.os.Bundle

class MainActivity: Application() {
    lateinit var repository: CapsuleRepository
        private set

    override fun onCreate() {
        super.onCreate()
        val db = AppDatabase.getDatabase(this)
        val api = Retrofit.Builder()
            .baseUrl("https://future-me-api.charmbytes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build
            .create(CapsulesApi::class.java)

        repository = CapsuleRepository(db.capsuleDao(), api)
    }
}
