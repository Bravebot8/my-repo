package com.example.mycountryapp

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MyClass {

    fun titleCase(text: String): String {
        if (text.isEmpty()) return text
        return text[0].uppercase() + text.substring(1).lowercase()
    }


    fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("MMM dd, HH:mm:ss ZZZZ", Locale.getDefault())
        return sdf.format(Date())
    }
}


