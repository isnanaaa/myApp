package com.example.hanrry

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Foo(
    val name: String,
    val description: String,
    val photo: Int,
) : Parcelable
