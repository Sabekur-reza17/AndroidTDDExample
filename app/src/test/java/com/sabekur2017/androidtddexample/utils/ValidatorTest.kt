package com.sabekur2017.androidtddexample.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{
    @Test
    fun whenInputIsValid(){
        val amount = 100
        val  description = "test description"
        val result = Validator.validateInput(amount, description)
        assertThat(result).isEqualTo(true)
    }
    @Test
    fun whenInputIsInvalid(){
        val amount = 0
        val description = ""
        val result = Validator.validateInput(amount, description)
        assertThat(result).isEqualTo(false)
    }
}