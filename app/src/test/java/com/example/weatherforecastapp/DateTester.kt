package com.example.weatherforecastapp

import android.content.Context
import com.example.weatherforecastapp.app.data.utils.DateHelper
import org.junit.Assert.*
import org.junit.Test
import org.powermock.api.mockito.PowerMockito
import java.lang.String.format
import android.text.format.DateFormat
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito.mock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.util.*

class DateTester {

    //DateFormat.format("dd MMM yyyy , HH:mm:ss", calendar)

//    @Test
//    fun testDateFormat(){
//        val context = mock(Context::class.java)
//        val calendar = Calendar.getInstance()
//        val dateFormat = DateFormat.getDateFormat(context)
//        PowerMockito.mockStatic(Calendar::class.java)
//        PowerMockito.mockStatic(DateFormat::class.java)
//        val resultForTest = DateHelper.convertTimeStampToDate(1663840196L)
//        assertEquals("22 Sep 2022 , 16:49:56",resultForTest)
//    }
}