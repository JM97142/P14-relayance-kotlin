package com.kirabium.relayance

import com.kirabium.relayance.domain.model.Customer
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test
import java.util.Calendar

class CustomerTest {

    @Test
    fun isNewCustomer_shouldReturnTrue_ifCreatedLessThan3MonthsAgo() {
        val recentDate = Calendar.getInstance().apply {
            add(Calendar.MONTH, -2)
        }.time

        val customer = Customer(1, "Test", "test@test.com", recentDate)

        assertTrue(customer.isNewCustomer())
    }

    @Test
    fun isNewCustomer_shouldReturnFalse_ifCreatedMoreThan3MonthsAgo() {
        val oldDate = Calendar.getInstance().apply {
            add(Calendar.MONTH, -6)
        }.time

        val customer = Customer(2, "Test", "test@test.com", oldDate)

        assertFalse(customer.isNewCustomer())
    }

    @Test
    fun isNewCustomer_shouldReturnTrue_ifCreatedExactly3MonthsAgo() {
        val threeMonthsAgo = Calendar.getInstance().apply {
            add(Calendar.MONTH, -3)
        }.time

        val customer = Customer(3, "Test", "test@test.com", threeMonthsAgo)

        assertTrue(customer.isNewCustomer())
    }
}