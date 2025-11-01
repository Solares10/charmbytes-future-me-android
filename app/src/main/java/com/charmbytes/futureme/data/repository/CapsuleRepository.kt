package com.charmbytes.futureme.data.repository

import com.charmbytes.futureme.data.model.Capsule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CapsuleRepository (
    private val dao: capsuleDao,
    private val api: CapsuleApi,
) {

    // LOCAL (Room) operations
    val allLetters: Flow<List<Capsule>> = dao.getAllLetters()
    val deliveredLetters: Flow<List<Capsule>> = dao.getDeliveredLetters()
    val upcomingLetters: Flow<List<Capsule>> = dao.getUpcomingLetters()

    suspend fun insertLetter(letter: Capsule) {
        dao.insert(letter)
    }

    suspend fun deleteLetter(id: String) {
        dao.deleteLetter(id)
    }

    suspend fun getLetterbyID(id: String): Letter? {
        return dao.getLetterByID(id)
    }

    // REMOTE (API) operations
    suspend fun fetchLettersFromServer(token: String) = withContext(Dispatchers.IO) {
        try {
            val response = api.getLetters(token)
            dao.insertAll(response)         // cache them locally
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun sendLetterToServer(token: String, letter: Capsule): Capsule? withContext(Dispatchers.IO) {
        try {
            val created = api.createLetter("Bearer $token", letter)
            dao.insert(created)
            return created
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

}
