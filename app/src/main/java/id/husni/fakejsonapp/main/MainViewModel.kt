package id.husni.fakejsonapp.main

import android.util.Log
import androidx.lifecycle.ViewModel
import id.husni.fakejsonapp.data.model.Users
import id.husni.fakejsonapp.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    suspend fun getUser(): Flow<List<Users>> {
        return flow {
            try {
                val dataArray = apiService.getUsers()
                if (dataArray.isNotEmpty()) {
                    emit(dataArray)
                }
            } catch (e: Exception) {
                Log.e("Coroutine Error", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}