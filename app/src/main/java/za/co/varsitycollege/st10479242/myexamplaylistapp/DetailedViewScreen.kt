package za.co.varsitycollege.st10479242.myexamplaylistapp
//ST10479242
//Aneeq Harris
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailedViewScreen : AppCompatActivity() {

    private lateinit var textViewPlaylistDetails: TextView
    private lateinit var backBtn: Button
    private lateinit var buttonAverageRating: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        textViewPlaylistDetails = findViewById(R.id.textViewPlaylistDetails)
        backBtn = findViewById(R.id.backBtn)

        // Set up average rating button
        buttonAverageRating.setOnClickListener {
            calculateAndDisplayAverageRating()
        }
        // Set up back to main button
        backBtn.setOnClickListener {
            finish()
        }


        // Get playlist data from intent
        val playlistData = intent.getStringArrayListExtra("playlist_data")

        if (playlistData != null && playlistData.isNotEmpty()) {
            displayPlaylistDetails()
        } else {
            textViewPlaylistDetails.text = "No songs in playlist yet."
        }
    }

    private fun displayPlaylistDetails() {
        TODO("Not yet implemented")
    }


    private fun calculateAndDisplayAverageRating() {
        val currentSongCount = null
        if (currentSongCount == 0) {
            Toast.makeText(this, "Playlist is empty! Add some songs first.", Toast.LENGTH_SHORT)
                .show()
            return
        }

        fun navigateToMainScreen() {
            val intent = Intent(this, MainActivity::class.java)
            backBtn.setOnClickListener {
                finish()
            }
        }
    }
}