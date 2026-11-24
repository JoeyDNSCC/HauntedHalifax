package com.example.hauntedhalifax.navigation

import android.R.attr.contentDescription
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
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hauntedhalifax.ui.theme.LightGreen
import com.example.hauntedhalifax.ui.theme.NavyBlue
import com.example.hauntedhalifax.ui.map.MapScreen
import com.example.hauntedhalifax.ui.theme.BodyFont
import com.example.hauntedhalifax.ui.theme.Creepy
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map



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
