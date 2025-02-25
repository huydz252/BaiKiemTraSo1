package com.example.test1

import ProductDetailScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Dữ liệu sản phẩm mẫu
data class Product(
    val id: String,
    val name: String,
    val des: String,
    val imageUrl: Int,
    val price: String,
    val rating: Float,
    val reviews: List<String> = emptyList() // Danh sách đánh giá
)


val sampleProducts = listOf(
    Product("1", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong1, "$12.99", 4.5f),
    Product("2", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong2, "$12.99", 4.5f),
    Product("3", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong3, "$12.99", 4.5f),
    Product("4", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
    Product("5", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
    Product("6", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
)


@Composable
fun ProductListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopBar()
        LazyColumn(contentPadding = PaddingValues(8.dp)) {
            items(sampleProducts) { product ->
                ProductItem(product = product, onClick = {
                    println("Clicked on ${product.name}")
                })
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                "New Arrivals",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, 
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier.clickable { /* Xử lý khi bấm vào */ }
                )

            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        ),
        modifier = Modifier.shadow(elevation = 4.dp)
    )
}


@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)) // Bo góc mượt hơn
            .clickable { onClick() }, // ✅ Gọi onClick() đúng
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = "Ảnh sản phẩm",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)) // Bo tròn hình ảnh
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                // Name
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 20.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Description
                Text(
                    text = product.des,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Rating
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${product.rating}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF9800) // Màu cam cho điểm rating
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(18.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Price & Add Button
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)) // Bo tròn viền
                        .background(Color(0xFFF1F1F1)) // Màu nền nhẹ nhàng
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = product.price,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF388E3C) // Màu xanh lá
                    )
                    IconButton(onClick = { /* Thêm vào giỏ hàng */ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add to cart",
                            tint = Color(0xFF00796B) // Màu xanh biển đậm
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun MainScreen(navController: NavController) {
    val productList = listOf(
        Product("1", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong1, "$12.99", 4.5f),
        Product("2", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong2, "$12.99", 4.5f),
        Product("3", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong3, "$12.99", 4.5f),
        Product("4", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
        Product("5", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
        Product("6", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
        Product("7", "DANVOUY Women's T-Shirt", "Áo thun nam được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt, mang lại cảm giác thoải mái suốt cả ngày. Thiết kế đơn giản nhưng không kém phần thời trang, dễ dàng phối với nhiều trang phục khác nhau. Đường may tỉ mỉ, form áo chuẩn giúp tôn dáng người mặc.", R.drawable.aophong4, "$12.99", 4.5f),
    )

    LazyColumn {
        items(productList) { product ->
            ProductItem(product = product, onClick = {
                navController.navigate("productDetail/${product.id}") // Điều hướng đến trang chi tiết
            })
        }
    }
}


fun getProductById(id: Int): Product? {
    return sampleProducts.find { it.id == id.toString() }
}



@Composable
fun AppNavigation() {
    val navController = rememberNavController() // ✅ Đảm bảo NavController được khai báo đúng

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(navController) // ✅ Truyền navController đúng
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: 0
            val selectedProduct = getProductById(productId)

            selectedProduct?.let { product ->
                ProductDetailScreen(
                    product = product,
                    onBackClick = { navController.popBackStack() } // Dùng navigateUp() thay vì popBackStack()
                )
            }
        }
    }
}


