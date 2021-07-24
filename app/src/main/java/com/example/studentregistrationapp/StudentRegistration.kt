package com.example.studentregistrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.studentregistrationapp.Api.ApiClient
import com.example.studentregistrationapp.Api.ApiInterface
import com.example.studentregistrationapp.Models.RegistrationRequest
import com.example.studentregistrationapp.Models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentRegistration : AppCompatActivity() {
    lateinit var courses: Button
    lateinit var Register:Button
    lateinit var nationality:Spinner
    lateinit var etDob: EditText
    lateinit var etName: EditText
    lateinit var etPassword:EditText
    lateinit var etEmail:EditText
    lateinit var etPhone:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_registration)
        castViews()
        onClick()
    }


    fun castViews(){
        courses=findViewById(R.id.btncourses)
        Register=findViewById(R.id.btnRegister)
        nationality=findViewById(R.id.spnationality)
         etDob=findViewById(R.id.etDob)
         etName=findViewById(R.id.etName)
       etPassword=findViewById(R.id.etPassword)
        etEmail=findViewById(R.id.etEmail)
         etPhone=findViewById(R.id.etPhone)

        var allnationalities= arrayOf("KENYAN","UGANDAN","RWANDAN","Burundi","SOUTH SUDAN")
        var nationalityAdapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,allnationalities)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        nationality.adapter=nationalityAdapter
    }
    fun onClick(){
        courses.setOnClickListener {
            var intent=Intent(baseContext,LoginActivity::class.java)
            startActivity(intent)
        }

        Register.setOnClickListener {
            var name=etName.text.toString()
            var email=etEmail.text.toString()
            var Dob=etDob.text.toString()
            var password=etPassword.text.toString()
            var phone=etPhone.text.toString()
            var nationalitychoice=nationality.selectedItem.toString()

            var registrationRequest=RegistrationRequest(
                name=name,email=email,password = password, dateOfBirth = Dob,phoneNumber = phone,nationality = nationalitychoice
            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            val request = retrofit.registerStudent(registrationRequest)
            request.enqueue(object :Callback<RegistrationResponse>{
                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext, "Successful Registration", Toast.LENGTH_LONG).show()

                    }
                    else{
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                .show()
                        } catch (e: Exception) {
                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }

                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()


                }

            })


        }

    }
}

data class ApiError(var errors: List<String>)