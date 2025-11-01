package com.charmbytes.futureme.data

import com.charmbytes.futureme.model.Capsule
import retrofit2.http.*

interface CapsulesApi {
    @GET("api/letters")
    suspend fun getLetters(
        @Header("Authorization") token: String
    ): List<Capsule>

    @POST("api/letters")
    suspend fun createLetter(
        @Header("Authorization") token: String,
        @Body letter: Capsule
    ): Capsule

}