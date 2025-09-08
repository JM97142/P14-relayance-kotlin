package com.kirabium.relayance

import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateExtTest {

    @Test
    fun toHumanDate_shouldFormatDateCorrectly() {

        val calendar = Calendar.getInstance().apply {
            set(2022, Calendar.JANUARY, 15)
        }

        val date = calendar.time
        val formatted = date.toHumanDate()
        val expected = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)

        assertEquals(expected, formatted)
    }
}