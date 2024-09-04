package com.example.firestorekotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    lateinit var logInButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        logInButton = findViewById<Button>(R.id.logInButton)
        logInButton.setOnClickListener({
            var i: Intent = Intent(this, MainActivity2::class.java)
            startActivity(i)
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}/*

Instruktioner:I uppgift 2: LifeCycle v.4,  ni skapa en app som har minst 2
Activities/fragments (2 sidor), som har ett inloggingssystem samt en profilsida
där man kan fylla i personuppgifter.

Godkänt kriterier:
****Första Activiten: En login sida som gå vidare till nästa Activity/fragment när man loggar in. (hårdkodat credentials är ok minst 2 inputs t.ex lösen ,password, username, personnummer, telenummer)
*Andra Activiten/fragment:
 ett “formulär” som låter användaren fylla i 5 olika typer av data/ui componenter & kan skicka/submita datan. (t.ex. åldern : skriv in siffror ,  har körkort : tickar in en checkbox, radiobox för olika alternativ, email: textinput )
Ni ska dessutom skapa en meny (av valfri typ som funkar som en meny) som kan navigara till alla Activities/fragment när man är inloggad.
Ha en custom icon för appen.
Spara data:  visar upp någon sparad data om man har fyllt i, om den finns , ska spara den om man pausar/lägger den i "app tray" + när man dödar appen också.
Har koden skriven i Kotlin (minst 50% kodradsmässigt).

Väl godkänt kriterier uppfyll 3 av 6 punkterna :

Extra Activiten/fragment för en registreringssida med input för credentials t.ex lösen , email , användarnamn , personnummer .
Använd Regex eller custom kod för att validera inputen från användaren för respektive inputfält, går ej att submitta annars (android kan också kolla utan hjälp från regexen, men ha majoriteten med regex).
Sparar alla saker man har fyllt i om man skulle backa, spara den aktiv inputen som man hann fylla i sist. (hint:SavedInstanceState eller SharedPreferences)
Spara all data även när man stänger appen & ha autoinlogg så att man kan skippa skriva in credentials igen (hint: vissa UI element spara info by default, SavedInstanceState eller
SharedPreferences)
Ha koden 100% helt i kotlin.
Använd en databas för att spara credentials / personuppgifter (säg till att andra kan testa den).
--
namnge repot till: [Mobilt java23] [FullNamn] [Uppgiftens namn utan punkt]
t.ex: Mobilt_java23_Alrik_He_LifeCycle_v4
Inlämning: githublänk som inlämningsuppgift, tills på fredag.
5 min presentation av appen på torsdag eftermiddagen (appen behöver ej vara klar) eller rapport på 150 ord.*/