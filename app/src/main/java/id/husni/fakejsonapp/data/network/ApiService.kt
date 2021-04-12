package id.husni.fakejsonapp.data.network

import id.husni.fakejsonapp.data.model.Users
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>
}