package com.example.customlistview2

import android.graphics.Bitmap
import android.net.Uri
import java.io.Serializable

class Product (
    val name: String,
    val price: String,
    val description: String,
    val image: String?

) :Serializable