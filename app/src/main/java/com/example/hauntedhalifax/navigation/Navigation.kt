package com.example.hauntedhalifax.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hauntedhalifax.ui.theme.LightGreen
import com.example.hauntedhalifax.ui.theme.NavyBlue
import com.example.hauntedhalifax.ui.map.MapScreen


//This OptIn is for the TopAppBar.
@OptIn(ExperimentalMaterial3Api::class)
//
@Composable
fun Navigation() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Haunted Halifax")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
//                        Icon(...)
                    },
                    label = {
                        Text("Map")
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
