package com.example.davaleba6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var email : EditText
    private lateinit var password : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        password = findViewById(R.id.password)
        email = findViewById(R.id.email)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val pass = password.text.toString()
            val mail = email.text.toString()
            if(pass.isEmpty() || mail.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}