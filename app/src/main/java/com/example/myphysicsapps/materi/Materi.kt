package com.example.myphysicsapps.materi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Materi(
    var judul: String,
    var foto : Int,
    var analogy : String,
    var rumus : Int,
    var penjelasan : String
):Parcelable
