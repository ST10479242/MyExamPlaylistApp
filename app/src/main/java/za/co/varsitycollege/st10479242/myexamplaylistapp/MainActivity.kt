package za.co.varsitycollege.st10479242.myexamplaylistapp
//ST10479242
//Aneeq Harris

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Declaring Variables
        val addBtn = findViewById<Button>(R.id.addBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val songText = findViewById<TextView>(R.id.songText)


        //Declaring arrays for names of artists
        val artistNames = arrayOf(
            "Kendrik lamar",
            "Justin bieber",
            "Eminem",
            "Tommy Richman"

        )
        //Declaring arrays for song
        val Songs = arrayOf(
            "Not like us.",
            "Baby.",
            "Godzilla.",
            "Million Dollar Baby."
        )
        //Declaring arrays for ratings
        val ratings = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5"
        )
        //Declaring arrays for comments
        val comments = arrayOf(
            "Rap",
            "love",
            "Rap",
            "Hip pop"
        )



        addBtn.setOnClickListener {
            Toast.makeText(this, "Song added to playlist", Toast.LENGTH_SHORT).show()
        }

        nextBtn.setOnClickListener {

            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}

