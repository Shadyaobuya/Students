package com.example.studentregistrationapp.Api
import android.graphics.PostProcessor
import com.example.studentregistrationapp.Models.LoginRequest
import com.example.studentregistrationapp.Models.LoginResponse
import com.example.studentregistrationapp.Models.RegistrationRequest
import com.example.studentregistrationapp.Models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>

    @POST("/students/login")
    fun loginStudent(@Body loginRequest:LoginRequest):Call<LoginResponse>

}


