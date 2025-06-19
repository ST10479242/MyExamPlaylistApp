package za.co.varsitycollege.st10479242.myexamplaylistapp
//ST10479242
//Aneeq Harris

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val songText = findViewById<TextView>(R.id.songText)

        val artistNames = arrayOf(
            "Kendrik lamar",
            "Justin bieber",
            "Eminem",
            "Tommy Richman"

        )
        val Songs = arrayOf(
            "Not like us.",
            "Baby.",
            "Godzilla.",
            "Million Dollar Baby."
        )
        val ratings = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5"
        )



        addBtn.setOnClickListener {
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

