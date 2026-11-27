package com.example.hauntedhalifax.ui.screens

import android.icu.text.UnicodeSetSpanner
import android.location.Location
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hauntedhalifax.MainViewModel
import com.mapbox.geojson.Point
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.Marker
import com.mapbox.maps.plugin.attribution.Attribution
import com.mapbox.maps.plugin.scalebar.ScaleBar
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.style.MapStyle

@OptIn(MapboxExperimental::class)
@Composable
fun MapScreen(viewModel: MainViewModel) {

    val location = viewModel.location

    if (location == null) {
        Text("Loading...")
    } 
    else {
        //
        MapboxMap(
            Modifier.fillMaxSize(),
            mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    zoom(12.0)
                    center(Point.fromLngLat(lng, lat))
                    pitch(0.0)
                    bearing(0.0)
                }
            },
            scaleBar = {
                ScaleBar(Modifier.padding(top = 60.dp))
            },
            logo = {
                Logo(Modifier.padding(bottom = 40.dp))
            },
            attribution = {
                Attribution(Modifier.padding(bottom = 40.dp))
            },
            style = {
                MapStyle(
                    style = "mapbox://styles/mattbutch/cmwyzhrbm00sh01rz7fg95iqb"
                )
            },
        ) {
            Marker(
                point = Point.fromLngLat(lng, lat),
                text = "You are Here",
                color = Color.Magenta
            )
        }
    }
}
