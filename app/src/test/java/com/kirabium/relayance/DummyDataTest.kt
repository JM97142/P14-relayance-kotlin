package com.kirabium.relayance

import com.kirabium.relayance.data.DummyData
import org.junit.Test
import org.junit.Assert.assertEquals
import java.util.Calendar

class DummyDataTest {

    @Test
    fun generateDate_shouldReturnDateXMonthsBack() {
        val monthsBack = 6
        val generatedDate = DummyData.generateDate(monthsBack)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -monthsBack)

        val expectedMonth = calendar.get(Calendar.MONTH)
        val expectedYear = calendar.get(Calendar.YEAR)

        val resultCalendar = Calendar.getInstance().apply {
            time = generatedDate
        }

        assertEquals(expectedMonth, resultCalendar.get(Calendar.MONTH))
        assertEquals(expectedYear, resultCalendar.get(Calendar.YEAR))
    }
}