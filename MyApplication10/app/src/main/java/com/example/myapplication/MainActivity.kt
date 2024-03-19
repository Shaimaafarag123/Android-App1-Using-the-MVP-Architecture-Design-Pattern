package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainActivityContract.view {

    private lateinit var presenter: MainActivityContract.presenter

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btn_login = findViewById(R.id.btn_login)

        // Set OnClickListener for the login button
        btn_login.setOnClickListener {
            // Validate inputs
            val email1 = email.text.toString()
            val password1 = password.text.toString()

            if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                onError("Field(s) Required")
            } else {
                presenter.doLogin(email1, password1)
            }
        }
    }

    override fun onSuccess(message: String) {
        // Handle success scenario
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onError(message: String) {
        // Handle error scenario
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
