package com.syed.schoolinfoapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    viewModel: SchoolInfoViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.SchoolListScreen.route
    ) {
        composable(route = Screen.SchoolListScreen.route) {
            SchoolListScreen(viewModel = viewModel, navHostController = navHostController)
        }
        composable(
            route = Screen.SchoolDetailScreen.route,
            arguments = listOf(navArgument("para") {
                type = NavType.StringType
            })
        ) {
            SchoolDetailScreen(it.arguments?.getString("para").toString())
        }
    }
}