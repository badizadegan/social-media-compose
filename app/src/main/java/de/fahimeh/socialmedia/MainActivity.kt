package de.fahimeh.socialmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.fahimeh.socialmedia.ui.navigation.AppNavGraph
import de.fahimeh.socialmedia.ui.theme.SocialMediaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialMediaComposeTheme {
                AppNavGraph()
            }
        }
    }
}