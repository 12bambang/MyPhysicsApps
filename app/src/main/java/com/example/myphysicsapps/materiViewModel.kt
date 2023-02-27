package com.example.myphysicsapps

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class materiViewModel : ViewModel() {
    private val _materiSearch = MutableLiveData<MateriResponse>()
    val materiSearch: LiveData<MateriResponse> = _materiSearch

    private val _isloading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isloading

    fun SearchMateri() {
        _isloading.value = true
        val client = Apiconfig.getApiService().getMateri()
        client.enqueue(object : Callback<MateriResponse>{
            override fun onResponse(
                call: Call<MateriResponse>,
                response: Response<MateriResponse>
            ) {
                _isloading.value = false
                if(response.isSuccessful){
                    _materiSearch.value = response.body()
                }
            }

            override fun onFailure(call: Call<MateriResponse>, t: Throwable) {
                _isloading.value = false
                Log.d("gagal onFailure",t.message.toString())
            }

        })
    }
    fun getMateriDetail(): LiveData<MateriResponse> {
        return _materiSearch
    }
}