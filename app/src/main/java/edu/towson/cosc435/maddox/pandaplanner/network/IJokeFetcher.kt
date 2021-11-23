package edu.towson.cosc435.maddox.pandaplanner.network

import edu.towson.cosc435.maddox.pandaplanner.model.Joke

interface IJokeFetcher {
    suspend fun fetchJoke() : Joke
}