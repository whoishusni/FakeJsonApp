package id.husni.fakejsonapp.model

import com.google.gson.annotations.SerializedName

data class Users(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("website")
    val website: String
)
