package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.data.fake.fakeProduct
import com.example.kkneed.model.Product
import com.example.kkneed.ui.DetailAppBar
import com.example.kkneed.ui.DetailBottomBar
import com.example.kkneed.ui.DetailList
import com.example.kkneed.ui.DetailTabBar
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun ScanResultScreen(
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel(),
    ) {
    val tempProduct: Product by viewModel.nowProduct.observeAsState(fakeProduct)
    val productState = viewModel.nowProduct.observeAsState()
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val key = "scan"
    Scaffold(
        topBar = {
            DetailAppBar(appBarHeight = 64.dp, navController = navController)
        },
        bottomBar = {
            DetailBottomBar()
        }
    ) {
        productState.value?.let {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.onPrimary)
            ) {
                item {
                    DetailList(
                        title = tempProduct.productName,
                        company = tempProduct.brands,
                        productImage = tempProduct.imageUrl,
                        score = tempProduct.scoreGrade,
                    )
                }
                item {
                    DetailChip(state = false, title = tempProduct.tracesTags)
                }
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }
                item {
                    DetailTabBar(product = tempProduct)
                }
            }
        }
    }
}

@Preview
@Composable
fun ScanResultPreview() {
    KKNeedTheme {

    }
}