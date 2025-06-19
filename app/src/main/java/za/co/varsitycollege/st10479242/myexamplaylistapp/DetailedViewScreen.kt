package za.co.varsitycollege.st10479242.myexamplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewScreen : AppCompatActivity() {

    private lateinit var textViewPlaylistDetails: TextView
    private lateinit var backBtn: Button
    private lateinit var buttonAverageRating : Button

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
            navigateToMainScreen()
        }

        // Get playlist data from intent
        val playlistData = intent.getStringArrayListExtra("playlist_data")

        if (playlistData != null && playlistData.isNotEmpty()) {
            displayPlaylistDetails(playlistData)
        } else {
            textViewPlaylistDetails.text = "No songs in playlist yet."
        }
    }

    private fun calculateAndDisplayAverageRating() {
        TODO("Not yet implemented")
    }

    private fun displayPlaylistDetails(playlistData: ArrayList<String>) {
        val detailsBuilder = StringBuilder()
        detailsBuilder.append("Playlist Details:\n\n")

        // Use traditional for loop with array-like access
        for (i in 0 until playlistData.size) {
            detailsBuilder.append("${i + 1}. ${playlistData[i]}\n\n")
        }

        detailsBuilder.append("Total Songs: ${playlistData.size}")

        textViewPlaylistDetails.text = detailsBuilder.toString()
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish() // Close current activity
    }
}