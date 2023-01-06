package com.sabekur2017.androidtddexample.utils

object Validator {
    fun validateInput(amount:Int,description:String):Boolean{
        return !(amount <= 0 || description.isEmpty())
    }
}