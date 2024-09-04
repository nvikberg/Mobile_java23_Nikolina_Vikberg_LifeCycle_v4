package com.example.firestorekotlin

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity2 : AppCompatActivity() {

    var db = Firebase.firestore

    lateinit var firstNameInput: EditText
    lateinit var lastNameInput: EditText
    lateinit var phoneNumberInput: EditText
    lateinit var passwordInput: EditText
    lateinit var submitButton: Button;

    lateinit var firstName:String
    lateinit var lastName:String
    lateinit var phoneNumber:String
    lateinit var password:String


    fun write() {
        val users = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "phoneNumber" to phoneNumber,
            "password" to password

        )

        db.collection("users").add(users).addOnSuccessListener { documentReference ->
            Log.d("niko", "DocumentSnapshot added with ID: ${documentReference.id}")
        }.addOnFailureListener { e ->
            Log.w("niko", "Error adding document", e)
        }

    }

    fun read(){
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("niko", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("niko", "Error getting documents.", exception)
            }

    }

    fun delete(){
        db.collection("users").document("fN5DVfv73RuwzdjkHhhr")
            .delete()
            .addOnSuccessListener { Log.d("niko", "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w("niko", "Error deleting document", e) }
    }

    fun update(){
        val users = hashMapOf(
            "first" to "Kitty",
            "last" to "Lovelace",
            "born" to 1999,
        )


        db.collection("users").document("fN5DVfv73RuwzdjkHhhr")
            .set(users)
            .addOnSuccessListener { Log.d("niko", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("niko", "Error writing document", e) }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val db = Firebase.firestore

        firstNameInput = findViewById(R.id.firstName)
        lastNameInput = findViewById(R.id.lastName)
        phoneNumberInput = findViewById(R.id.phoneNumber)
        passwordInput = findViewById(R.id.password)

        submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener{
           firstName = firstNameInput.text.toString()
            lastName = lastNameInput.text.toString()
            phoneNumber = phoneNumberInput.text.toString()
            password = passwordInput.text.toString()
            Log.d("niko", "User was added to database: first name:" + firstName +" lastname: " + lastName + "phone: " + phoneNumber)
            Toast.makeText(this, "Sent!", Toast.LENGTH_SHORT).show();
            write()
            //after should activity change.. or just the fragment
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

/*
ett “formulär” som låter användaren fylla i 5 olika typer av data/ui componenter & kan skicka/submita datan. (t.ex. åldern : skriv in siffror ,  har körkort : tickar in en checkbox, radiobox för olika alternativ, email: textinput )*/
