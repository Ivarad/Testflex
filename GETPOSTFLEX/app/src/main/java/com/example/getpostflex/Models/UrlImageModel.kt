package com.example.getpostflex.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UrlImageModel {
    @SerializedName("articles")
    @Expose
    var file: Array<Articles>? = null
}
class Articles
{
    @SerializedName("title")
    @Expose
    var file:String? = null
}
