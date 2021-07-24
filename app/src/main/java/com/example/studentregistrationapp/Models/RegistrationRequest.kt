package com.example.studentregistrationapp.Models
import com.google.gson.annotations.SerializedName


data class RegistrationRequest(
    var name:String,
    @SerializedName("phone_number") var phoneNumber:String,
    var email:String,
    @SerializedName("date_of_birth") var dateOfBirth:String,
    var nationality:String,
    var password:String
)






//    POST http://13.244.243.129/students/register
//{
//    "name": "Anna Banana",
//    "phone_number": "0700000001",
//    "email": "annab9@gmail.com",
//    "date_of_birth": "2000-06-18",
//    "nationality": "UGANDAN",
//    "password": "banana123"
//}


