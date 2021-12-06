package edu.towson.cosc435.maddox.pandaplanner.model

data class Joke(
    val joke: String
){
    override fun toString(): String {
        return "$joke"
    }
}