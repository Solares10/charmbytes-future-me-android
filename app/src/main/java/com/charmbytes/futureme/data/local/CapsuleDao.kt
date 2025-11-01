package com.charmbytes.futureme.data.local
import androidx.room.Dao
import com.charmbytes.futureme.data.model.Capsule
import kotlinx.coroutines.flow.Flow

@Dao interface CapsuleDao {

    // Insert a new letter or update if the same ID already exists
    @Insert(onConflict = onConflictStrategy.REPLACE)
    suspend fun insert(letter: Capsule)

    // Insert multiple at once (when we need to sync backend)
    @Insert(onConflict = onConflictStrategy.REPLACE)
    suspend fun insertAll(letters: List<Capsule>)

    // Get all letters, sorted by delivery date
    @Query("")
    fun getAllLetters(): Flow<List<Capsule>>

    // Get only letters that have been delivered
    @Query("")
    fun getDeliveredLetter(): Flow<List<Capsule>>

    // Get letters that are still locked (upcoming)
    fun getUpcomingLetters(): Flow<List<Capsule>>

    // Get letter by its ID
    @Query("")
    suspend fun getLetterByID(id: String): Letter?

    // Delete a letter by ID
    @Query("")
    suspend fun deleteLetter(id: String)

    // Delete all delivered letters (for cleanup)
    @Query("")
    suspend fun deleteDeliveredLetters()

}
