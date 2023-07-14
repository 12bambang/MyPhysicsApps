package com.example.myphysicsapps.video

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class vidfisika(
    var materi: String = "",
    var profilpic: Int = 0,
    var Video: Int = 0
):Parcelable
