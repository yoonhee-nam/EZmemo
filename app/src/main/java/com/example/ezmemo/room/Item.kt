package com.example.ezmemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey
    val id : Int = 0,
    val name : String
)
