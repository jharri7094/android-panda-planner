package edu.towson.cosc435.maddox.pandaplanner.db

import androidx.room.*
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.User

@Dao
interface PandaDAO {

    @Query("SELECT userId FROM user WHERE username = :username AND password = :password")
    suspend fun getUserId(username : String, password : String) : Long?

    @Query("SELECT * FROM event WHERE userId = :userId ")
    suspend fun getEvents(userId: Long): List<Event>

    @Insert
    suspend fun insertNewUser(user : User)

    @Insert
    suspend fun insertNewEvent(event: Event)

    @Delete
    suspend fun deleteEvent(event : Event)

    @Update
    suspend fun updateEvent(event : Event)



}