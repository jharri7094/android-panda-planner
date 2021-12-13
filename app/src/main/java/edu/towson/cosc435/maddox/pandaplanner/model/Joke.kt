package edu.towson.cosc435.maddox.pandaplanner.model

data class Joke(
    val id : String,
    val joke: String,
    val status : Int
) {
    override fun toString(): String {
        return joke
    }
}
