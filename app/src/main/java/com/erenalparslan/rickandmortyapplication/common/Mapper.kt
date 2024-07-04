package com.erenalparslan.rickandmortyapplication.common

interface Mapper<I,O>{
    fun map(input:I):O
}