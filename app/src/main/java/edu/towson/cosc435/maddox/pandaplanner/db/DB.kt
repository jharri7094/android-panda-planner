package edu.towson.cosc435.maddox.pandaplanner.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.User

@Database(entities =
[   User::class,
    Event::class
], version=1)
abstract class DB : RoomDatabase() {
    abstract fun pandaDAO() : PandaDAO
    companion object {
        private var INSTANCE: DB? = null
        fun getDatabase(context: Context): DB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, DB::class.java, "PandaDB")
                            .fallbackToDestructiveMigration()
                            //.createFromAsset("databases/HealthDB.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}