package com.example.hauntedhalifax.ui.screens

import android.location.Location
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MapScreen(location: Location?) {
    Column() {
        Text("Map Screen")
        Text(text = "Latitude: ${location?.latitude} Longitude: ${location?.longitude}")
    }
}