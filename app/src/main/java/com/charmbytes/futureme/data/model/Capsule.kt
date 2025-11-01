package com.charmbytes.futureme.data.model

import com.google.gson.annotations.SerializedName
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "letters")
data class Capsule (
    @SerializedName("_id")
    @PrimaryKey val id:String = "",

    val title:String? = "",

    val message:String? = "",

    @SerializedName("createdAt")
    val createdAt:Date? = null,

    val delivered:Boolean = false,

    @SerializedName("deliveredAt")
    val deliveredAt:Date? = null,

    )


