package edu.towson.cosc435.maddox.pandaplanner.model

data class Joke(
    val setup : String,
    val punchline: String
){
    override fun toString(): String {
        return "$setup, $punchline"
    }
}