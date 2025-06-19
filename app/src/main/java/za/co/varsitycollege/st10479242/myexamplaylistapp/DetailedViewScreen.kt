package za.co.varsitycollege.st10479242.myexamplaylistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        intent.getStringArrayExtra("songs")
        intent.getStringArrayExtra("Rating")
        intent.getStringArrayExtra("artistName")

    }
}