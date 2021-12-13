package edu.towson.cosc435.maddox.pandaplanner.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val eventId : Long = 0,
    val userId : Long,
    val startDate: String,
    val endDate: String,
    val eventName: String,
    val eventDetails: String,
    val priority: String,
    val isCompleted: Boolean
)

enum class Priority{
    HIGH{
        override fun toString(): String {
            return "High"
        }
    },
    MEDIUM{
        override fun toString(): String {
            return "Medium"
        }
    },
    LOW{
        override fun toString(): String {
            return "Low"
        }
    }
}

