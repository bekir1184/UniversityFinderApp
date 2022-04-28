package com.beko.universityfinderapp.ui.main.homepage

import android.util.Log
import com.beko.universityfinderapp.api.RetrofitClient
import com.beko.universityfinderapp.model.University
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.concurrent.ArrayBlockingQueue
import javax.inject.Inject

class HomepageRepository @Inject constructor() {
    fun getUniversity() : MutableList<University>{
        val arrayBlockingQueue : ArrayBlockingQueue<MutableList<University>> = ArrayBlockingQueue(1)
        try {
            RetrofitClient.retrofitClient.getUniCountry("Turkey").enqueue(object : Callback<MutableList<University>>{
                override fun onResponse(
                    call: Call<MutableList<University>>,
                    response: Response<MutableList<University>>
                ) {
                    if(response.isSuccessful){
                        arrayBlockingQueue.add(response.body())
                    }else{
                        Log.e("HomePageRepository",response.code().toString())
                    }
                }

                override fun onFailure(call: Call<MutableList<University>>, t: Throwable) {
                    Log.e("HomePageRepository",t.message.toString())
                }

            })
        }catch (e : Exception){
            Log.e("HomePageRepository",e.message.toString())
        }
        return arrayBlockingQueue.take()
    }
}