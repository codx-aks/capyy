package com.example.capyy
import com.google.gson.annotations.SerializedName
data class tips(
    @SerializedName("tips")
    var tips:ArrayList<String> = arrayListOf()
)