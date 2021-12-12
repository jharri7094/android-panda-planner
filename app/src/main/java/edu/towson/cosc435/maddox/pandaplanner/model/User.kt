package edu.towson.cosc435.maddox.pandaplanner.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId : Long = 0,
    val username : String,
    val password : String
    )