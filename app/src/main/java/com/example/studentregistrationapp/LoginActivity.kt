package com.example.studentregistrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.studentregistrationapp.Api.ApiClient
import com.example.studentregistrationapp.Api.ApiInterface
import com.example.studentregistrationapp.Models.LoginRequest
import com.example.studentregistrationapp.Models.LoginResponse
import com.example.studentregistrationapp.Models.RegistrationRequest
import com.example.studentregistrationapp.Models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var etMail: EditText
    lateinit var etPassw: EditText
    lateinit var Login:Button
    lateinit var  back:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        castViews()
        onClick()
    }
fun castViews() {
    etMail = findViewById(R.id.etname)
    etPassw = findViewById(R.id.etpassword)
    Login = findViewById(R.id.btnlogin)
}
    fun onClick(){
        Login.setOnClickListener {
            var email=etMail.text.toString()
            var password=etPassw.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                etMail.setError("cant be blank")
                etPassw.setError("cant be blank")
            }
            else{
                var loginRequest=LoginRequest(
                    email=email,password=password
                )
                val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
                val request = retrofit.loginStudent(loginRequest)
                request.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG).show()
                            var intent= Intent(baseContext,CoursesPage::class.java)
                            startActivity(intent)
                        } else {
                            try {
                                val error = JSONObject(response.errorBody()!!.string())
                                Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                    .show()
                            } catch (e: Exception) {
                                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })
            }
            }


}
}




