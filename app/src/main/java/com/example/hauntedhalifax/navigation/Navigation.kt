package com.example.hauntedhalifax.navigation

import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hauntedhalifax.MainViewModel
import com.example.hauntedhalifax.ui.map.MapScreen
import com.example.hauntedhalifax.ui.theme.BodyFont
import com.example.hauntedhalifax.ui.theme.Creepy
import com.example.hauntedhalifax.ui.theme.LightGreen

// code for switching screens will go here
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//This OptIn is for the TopAppBar.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(viewModel: MainViewModel) {

    val navController = rememberNavController()

    // Begin: Ask permission to get device location.
    // Note: If permission is previously granted, the dialog won't appear and refreshLocation() will get called.
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        if (results.values.any { it }) {
            viewModel.refreshLocation() // call a function to get the current location for device
        }
    }

    LaunchedEffect(Unit) {
        launcher.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    // End: Ask permission to get device location.
    val location = viewModel.location
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Haunted Halifax",
                        color = LightGreen,
                        fontFamily = Creepy,
                        fontSize = 28.sp
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Map,
                            contentDescription = "Map",
                            tint = LightGreen
                        )
                    },
                    label = {
                        Text(
                            text = "Map",
                            color = LightGreen,
                            fontFamily = BodyFont
                        )
                    }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "Map",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Map") {
                MapScreen()
            }
        }
    }
}


