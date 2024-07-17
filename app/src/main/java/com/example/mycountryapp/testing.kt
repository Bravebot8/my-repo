package com.example.mycountryapp
import org.apache.commons.text.similarity.LevenshteinDistance

class testing {


    fun main() {
        val string1 = "kitten"
        val string2 = "sitting"

        val levenshteinDistance = LevenshteinDistance()
        val distance = levenshteinDistance.apply(string1, string2)

        println("Levenshtein distance between '$string1' and '$string2': $distance")
    }


    fun testMyFunction() {
        // Arrange
        val Funs = MyClass()
        val input = "test input"
        val input2 = "test input"
        val expectedOutput = "expected Output"

        val levenshteinDistance = LevenshteinDistance()
        val distance = levenshteinDistance.apply("kitt", "shitt")

        println("Levenshtein distance between '$input' and '$input2': $distance")
    }
}