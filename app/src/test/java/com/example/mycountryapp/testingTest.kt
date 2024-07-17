package com.example.mycountryapp

import org.apache.commons.text.similarity.LevenshteinDistance
import org.junit.jupiter.api.Assertions.*

class testingTest {

    @org.junit.jupiter.api.Test
    fun testMyFunction() {
        // Arrange
        val Funs = MyClass()
        val input = "test input"
        val input2 = "test input"
        val expectedOutput = "expected Output"

        val levenshteinDistance = LevenshteinDistance()
        val distance = levenshteinDistance.apply("kitt", "hitt")

        println("Levenshtein distance between '$input' and '$input2': $distance")
    }
}