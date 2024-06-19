package com.syed.schoolinfoapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.syed.schoolinfoapp.util.Resource

@Composable
fun SchoolListScreen(
    viewModel: SchoolInfoViewModel,
    navHostController: NavHostController
) {
    val schoolDetails by viewModel.schoolInfo.observeAsState(Resource.Loading(isLoading = true))
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val result = schoolDetails) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                LazyColumn {
                    result.data?.let {
                        items(it.size) { index ->
                            SchoolItemRow(school = it[index], navHostController = navHostController)
                        }
                    }

                }
            }

            is Resource.Error -> {
                Text(text = "Could not load data: ${result.message}")
            }
        }

    }
}