package com.example.fcc_challengefinal

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.widget.*
import androidx.core.view.*
import com.google.android.material.snackbar.Snackbar

abstract class MainActivity : AppCompatActivity() {

    private lateinit var nameTXT: EditText
    private lateinit var nameValid: EditText
    private lateinit var emailTXT: EditText
    private lateinit var emailValid: EditText
    private lateinit var passwdTXT: EditText
    private lateinit var passwdValid: EditText
    private lateinit var REpasswdTXT: EditText
    private lateinit var rePasswdValid: EditText
    private lateinit var pickImageBtn: Button
    private lateinit var registerBtn: Button
    private lateinit var countries: Spinner
    private lateinit var genderOpt: RadioGroup
    private lateinit var agree: CheckBox
    private lateinit var parent: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        pickImageBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@MainActivity, "Yet to talk about", Toast.LENGTH_SHORT).show()
            }
        })

        registerBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                initRegister()
            }
        })

    }

    private fun initRegister(){
        Log.d(TAG, "initRegister: Started")

        if (validateData()){
            if (agree.isChecked() == true){
                ShowSnackBar()
            } else {
                Toast.makeText(this, "You need to agree with the licence agreement to register", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ShowSnackBar(){
        Log.d(TAG, "ShowSnackBar: Started")
        nameValid.isVisible = false
        emailValid.isVisible = false
        passwdValid.isVisible = false
        rePasswdValid.isVisible = false

        val name: String = nameTXT.getText().toString()
        val email: String = emailTXT.getText().toString()
        val country = countries.getSelectedItem().toString()
        var gender = ""
        when (genderOpt.getCheckedRadioButtonId() ) {
            R.id.MaleBtn -> gender = "Male"
            R.id.femaleBtn -> gender = "Female"
            R.id.otherBtn -> gender = "Other"
            else -> {
                gender = "Not Specified"
            }
        }

        val snackText: String = "Name: "+name+"\nEmail: "+email+"\nCountry: "+country+"\nGender: "+gender
        Log.d(TAG, "ShowSnackBar: "+snackText)

        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", object : View.OnClickListener{
            override fun onClick(view : View?) {
                nameTXT.setText((""))
                emailTXT.setText("")
                passwdTXT.setText("")
                REpasswdTXT.setText("")
            }
        }).show()
    }

    private fun validateData(): Boolean {
        Log.d(TAG, "validateData: Started")
        if (nameTXT.getText().toString().equals(" ")) {
            nameValid.isVisible = true
            nameValid.setText("Enter your name")
            return false
        }
        if (emailTXT.getText().toString().equals(" ")) {
            emailValid.isVisible = true
            emailValid.setText("Enter your email")
            return false
        }
        if (passwdTXT.getText().toString().equals(" ")) {
            passwdValid.isVisible = true
            passwdValid.setText("Enter your password")
            return false
        }
        if (REpasswdTXT.getText().toString().equals(" ")) {
            rePasswdValid.isVisible = true
            rePasswdValid.setText("Re-enter your password")
            return false
        }
        if (REpasswdTXT.getText().toString().equals(passwdTXT)){
            rePasswdValid.isVisible = true
            rePasswdValid.setText("Password doesn't match")
            return false
        }
        return true
    }

    private fun initView(){
        Log.d(TAG, "initView: Started")
        nameTXT = findViewById(R.id.nameTXT)
        nameValid = findViewById(R.id.nameValid)
        emailTXT = findViewById(R.id.emailTXT)
        emailValid = findViewById(R.id.emailValid)
        passwdTXT = findViewById(R.id.passwdTXT)
        passwdValid = findViewById(R.id.passwdValid)
        REpasswdTXT = findViewById(R.id.REpasswdTXT)
        rePasswdValid = findViewById(R.id.rePasswdValid)
        pickImageBtn = findViewById(R.id.pickImageBtn)
        registerBtn = findViewById(R.id.registerBtn)
        countries =  findViewById(R.id.countryDrop)
        genderOpt = findViewById(R.id.radioGroup)
        agree = findViewById(R.id.checkAgree)
        parent = findViewById(R.id.parent)
    }
}
