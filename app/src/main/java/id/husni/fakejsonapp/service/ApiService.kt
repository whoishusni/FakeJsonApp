package id.husni.fakejsonapp.service

import id.husni.fakejsonapp.model.Users
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>
}