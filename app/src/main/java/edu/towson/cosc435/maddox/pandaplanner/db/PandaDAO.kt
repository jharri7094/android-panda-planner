package edu.towson.cosc435.maddox.pandaplanner.db

import androidx.room.*
import edu.towson.cosc435.maddox.pandaplanner.model.User

@Dao
interface PandaDAO {

    @Query("SELECT userId FROM user WHERE username = :username AND password = :password")
    suspend fun getUserId(username : String, password : String) : Long?

    @Insert
    suspend fun insertNewUser(user : User)
}