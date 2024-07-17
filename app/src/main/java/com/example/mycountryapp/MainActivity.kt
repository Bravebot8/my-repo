package com.example.mycountryapp

import com.example.mycountryapp.MyClass
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycountryapp.ui.theme.MyCountryAppTheme
import org.apache.commons.text.similarity.LevenshteinDistance




class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myFuns = MyClass()
        val myData = MyVals()

        val showCapitalButton = findViewById<Button>(R.id.run_search_button)  // Optional button
        val showTimeButton: Button = findViewById(R.id.show_time_button)
        val timeTextView: TextView = findViewById(R.id.time_text_view)
        val threshold = 3  // Maximum allowed edits (errors)

        // Time button click listener (unchanged)
        showTimeButton.setOnClickListener {
            val currentTime = myFuns.getCurrentTime()
            timeTextView.text = currentTime
        }

        // Capital search button click listener
        showCapitalButton?.setOnClickListener {
            val countryUserInput = findViewById<EditText>(R.id.country_input_box)
            val capitalTextView = findViewById<TextView>(R.id.capital_text_view)

            // Get user input, trim whitespace, and lowercase for case-insensitive matching
            val userInputFormatted = countryUserInput.text.toString().trim().lowercase()

            // Empty country check (unchanged)
            if (userInputFormatted.isEmpty()) {
                capitalTextView.text = getString(R.string.country_empty)  // Empty country message
                return@setOnClickListener  // Exit the listener if country is empty
            }

            // Find the closest matching capital city using Levenshtein distance
            var closestCountry: String? = null
            var minDistance = Int.MAX_VALUE  // Initialize with maximum distance

            for (country_key in myData.capitalCities.keys) {
                val distance = LevenshteinDistance().apply(country_key.lowercase(), userInputFormatted)
                if (distance <= threshold) {  // Check for distance less than or equal to threshold
                    if (distance < minDistance) {
                        closestCountry = country_key
                        minDistance = distance
                    }
                }
            }

            // Update text view based on the closest matching country
            if (closestCountry != null) {
                capitalTextView.text = getString(R.string.capital_found, closestCountry, myData.capitalCities[closestCountry]!!)  // Use !! for non-null access
            } else {
                capitalTextView.text = getString(R.string.capital_not_found, userInputFormatted)  // Capital not found message
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyCountryAppTheme {
            Greeting("Android")
        }
    }
}


