package com.example.weatherforecastapp.app.data.utils

import android.text.format.DateFormat
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun convertTimeStampToDate(timeStamp : Long): String {
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = timeStamp
        return DateFormat.format("dd MMM yyyy , HH:mm:ss", calendar).toString()
    }

    fun setDatePattern(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
}