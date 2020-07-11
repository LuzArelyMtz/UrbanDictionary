package com.nike.urbandictionary.utilities

import org.junit.Assert.*
import org.junit.Test

class DateFormatTest {
    @Test
    fun `Date correctly formatted` () {
        val givenDateToFormat = "2005-05-24T00:00:00.000Z"
        val expected = "24, may 2005"

        val output = DateFormat().getDate(givenDateToFormat)

        assert(output.equals(expected))
    }

    @Test
    fun `Date empty when an incorrect date format expected` () {
        // This given date is incorrect since it does not have day
        val givenDateToFormat = "2005-05T00:00:00.000Z"
        val expected = ""

        val output = DateFormat().getDate(givenDateToFormat)

        assert(output.equals(expected))
    }


}