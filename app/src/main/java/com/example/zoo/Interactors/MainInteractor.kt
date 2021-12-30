package com.example.zoo.Interactors

import android.util.Log
import com.example.zoo.AppCore.Core
import com.example.zoo.AppCore.Model.Exhibit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainInteractor {
    private val client = OkHttpClient().newBuilder().build()

    interface onFinishedLister {
        fun onSuccess(data: List<Exhibit>)
        fun onError(error:String)
    }

    fun loadData (onFinishedLister: onFinishedLister){
        var req = Request
            .Builder()
            .url("https://data.taipei/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
            .build()

        var call = client.newCall(req)

        call.enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFinishedLister.onError(e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                var rep = JSONObject(response!!.body()!!.string())
                var results = rep.getJSONObject("result").getJSONArray("results")

                var data = Gson().fromJson(results.toString(), Array<Exhibit>::class.java).toList()

                onFinishedLister.onSuccess(data)
            }
        })
    }
}