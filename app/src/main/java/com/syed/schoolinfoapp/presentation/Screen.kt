package com.syed.schoolinfoapp.presentation

import androidx.compose.ui.text.Paragraph

sealed class Screen(val route: String) {
    object SchoolListScreen: Screen("list_screen")
    object SchoolDetailScreen: Screen("detail_screen/{para}") {
        fun passPara(text: String): String {
            return "detail_screen/$text"
        }
    }
}