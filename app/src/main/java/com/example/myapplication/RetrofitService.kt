package com.example.myapplication

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("json/students/")
    fun getStudentsList():Call<ArrayList<NetworkPerson>>

    @POST("json/students/")
    fun createStudent(
        @Body params : HashMap<String, Any>
    ): Call<NetworkPerson>

    @POST("json/students/")
    fun createStudentEasy(
        @Body person: NetworkPerson
    ): Call<NetworkPerson>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register (
        @Field("username")username : String
        ,@Field("password1")passowrd1: String
        ,@Field("password2")password2: String
    ): Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String
        ,@Field("password") password: String
    ): Call<User>


    @GET("instagram/post/list/all/")
    fun getAllPosts(): Call<ArrayList<OutStarPost>>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image: MultipartBody.Part
        ,@Part ("content")requestBody: RequestBody
    ): Call<OutStarPost>

    @GET("instagram/post/list/")
    fun getUserPostList():Call<ArrayList<OutStarPost>>

    @GET("youtube/list/")
    fun getYoutubeList():Call<ArrayList<Youtube>>

    @GET("melon/list/")
    fun getMusicList():Call<ArrayList<Music>>
}