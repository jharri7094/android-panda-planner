package edu.towson.cosc435.maddox.pandaplanner.network

import android.util.Log
import android.util.Log.DEBUG
import androidx.compose.ui.tooling.data.JoinedKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.towson.cosc435.maddox.pandaplanner.BuildConfig.DEBUG
import edu.towson.cosc435.maddox.pandaplanner.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class JokeFetcher : IJokeFetcher {
    override suspend fun fetchJoke() : Joke {
        return withContext(Dispatchers.IO){
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://icanhazdadjoke.com/")
                .get()
                .addHeader("User-Agent", "Towson University student assignment, email: abmaddox@comcast.net")
                .addHeader("Accept", "application/json")
                .build()

            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if(json != null) {
                val gson = Gson()
                val typeToken = object : TypeToken<Joke>() {}
                val type = typeToken.type
                val joke = gson.fromJson<Joke>(json, type)
                joke
            }
            else
                Joke("some setup","some punchline")
        }

    }

}