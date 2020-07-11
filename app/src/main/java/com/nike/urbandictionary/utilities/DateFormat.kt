package com.nike.urbandictionary.utilities

import android.os.Build
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class DateFormat {

    fun getDate(firstDate: String): String {
        lateinit var desiredFormat: String
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                val date = formatter.parse(firstDate)
                desiredFormat = DateTimeFormatter.ofPattern("dd, MMM yyyy").format(date)
            } else {
                val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                val date = formatter.parse(firstDate)
                desiredFormat = SimpleDateFormat("dd, MMM yyyy").format(date)
            }
        } catch (e: ParseException) {
            desiredFormat = ""
        }

        return desiredFormat
    }
}