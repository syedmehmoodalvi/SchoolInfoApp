package com.syed.schoolinfoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.syed.schoolinfoapp.data.model.ApiResponseItem

@Composable
fun SchoolItemRow(
    school: ApiResponseItem,
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .clickable {
                val text = school.overview_paragraph
                navHostController.navigate(Screen.SchoolDetailScreen.passPara(text))
            }
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = school.school_name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = school.dbn,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            androidx.compose.material3.Text(
                text = "view detail",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}