package za.co.varsitycollege.st10479242.myexamplaylistapp
//ST10479242
//Aneeq Harris

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Using arrays instead of ArrayList
    private val playlist = Array<Song?>(MAX_SONGS) { null }
    private var currentSongCount = 0

    private lateinit var editTextTitle: EditText
    private lateinit var editTextArtist: EditText
    private lateinit var editTextRating: EditText
    private lateinit var buttonAddSong: Button
    private lateinit var buttonDetailedView: Button
    private lateinit var buttonExit: Button
    private lateinit var buttonDisplayPlaylist: Button

    companion object {
        const val MAX_SONGS = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextArtist = findViewById(R.id.editTextArtist)
        editTextRating = findViewById(R.id.editTextRating)
        buttonAddSong = findViewById(R.id.addBtn)
        buttonDetailedView = findViewById(R.id.buttonDetailedView)
        buttonExit = findViewById(R.id.exitBtn)
        buttonDisplayPlaylist = findViewById(R.id.buttonDisplayPlaylist)

        // Set up add song button
        buttonAddSong.setOnClickListener {
            addSongToPlaylist()
        }

        // Set up detailed view button
        buttonDetailedView.setOnClickListener {
            navigateToDetailedView()
        }

        // Set up display playlist button
        buttonDisplayPlaylist.setOnClickListener {
            displayPlaylistUsingLoop()
        }

        // Set up exit button
        buttonExit.setOnClickListener {
            exitApp()
        }
    }

    private fun addSongToPlaylist() {
        // Check if playlist is full using loop
        if (currentSongCount >= MAX_SONGS) {
            Toast.makeText(this, "Playlist is full! Maximum $MAX_SONGS songs allowed.", Toast.LENGTH_SHORT).show()
            return
        }

        val title = editTextTitle.text.toString().trim()
        val artist = editTextArtist.text.toString().trim()
        val ratingText = editTextRating.text.toString().trim()

        // Validate input
        if (title.isEmpty() || artist.isEmpty() || ratingText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val rating = ratingText.toDouble()
            if (rating < 0 || rating > 5) {
                Toast.makeText(this, "Rating must be between 0 and 5", Toast.LENGTH_SHORT).show()
                return
            }

            // Find first empty slot using loop
            var emptyIndex = -1
            for (i in 0 until MAX_SONGS) {
                if (playlist[i] == null) {
                    emptyIndex = i
                    break
                }
            }

            if (emptyIndex != -1) {
                // Create and add song to playlist array
                val newSong = Song(title, artist, rating)
                playlist[emptyIndex] = newSong
                currentSongCount++

                // Clear input fields
                editTextTitle.setText("")
                editTextArtist.setText("")
                editTextRating.setText("")

                Toast.makeText(this, "Song added to playlist! ($currentSongCount/$MAX_SONGS songs)", Toast.LENGTH_SHORT).show()
            }

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter a rating number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDetailedView() {
        (Intent(this, DetailedViewScreen::class.java))

        // Convert playlist array to string array using loops
        val playlistData = Array<String?>(MAX_SONGS) { null }
        var dataCount = 0

        for (i in 0 until MAX_SONGS) {
            if (playlist[i] != null) {
                playlistData[dataCount] = playlist[i].toString()
                dataCount++
            }
        }

        // Convert to ArrayList for intent (required by Android)
        val playlistList = ArrayList<String>()
        for (i in 0 until dataCount) {
            playlistData[i]?.let { playlistList.add(it) }
        }

        intent.putStringArrayListExtra("playlist_data", playlistList)
        startActivity(intent)
    }

    private fun exitApp() {
        finishAffinity() // Closes all activities and exits the app
    }

    private fun displayPlaylistUsingLoop() {
        if (currentSongCount == 0) {
            Toast.makeText(this, "Playlist is empty! Add some songs first.", Toast.LENGTH_SHORT).show()
            return
        }

        // Build playlist string using loops
        val playlistBuilder = StringBuilder()
        playlistBuilder.append("Current Playlist:\n\n")

        var displayCount = 1
        // Loop through array to display each non-null song
        for (i in 0 until MAX_SONGS) {
            if (playlist[i] != null) {
                val song = playlist[i]!!
                playlistBuilder.append("$displayCount. ${song.title}\n")
                playlistBuilder.append("   Artist: ${song.artist}\n")
                playlistBuilder.append("   Rating: ${song.rating}/5\n\n")
                displayCount++
            }
        }

        playlistBuilder.append("Total Songs: $currentSongCount/$MAX_SONGS")

        // Display playlist in a dialog
        AlertDialog.Builder(this)
            .setTitle("Playlist Display")
            .setMessage(playlistBuilder.toString())
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}
