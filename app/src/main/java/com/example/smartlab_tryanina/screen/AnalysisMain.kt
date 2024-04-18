package com.example.smartlab_tryanina.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder
import coil.size.Size.Companion.ORIGINAL
import com.example.smartlab_tryanina.models.ResultNews
import com.example.smartlab_tryanina.viewModel.MainViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AnalysysMain(navHost: NavHostController, viewModel: MainViewModel){
    /*val ListNews = viewModel.toGetNews.collectAsState().value
    val context = LocalContext.current
    *//** LaunchedEffect — это composable-функция, которая используется для запуска сопрограммы
    внутри области composable.Когда LaunchedEffect входит в композицию,
    он запускает сопрограмму и отменяет её при выходе из композиции .
     *
    LaunchedEffect принимает несколько ключей в качестве параметров,
    и если какой - либо из ключей изменяется, он может отменить существующую сопрограмму
    и запустить её снова . Это полезно для выполнения побочных эффектов,
    таких как сетевые вызовы или обновление базы данных, без блокировки потока пользовательского интерфейса*//*
    LaunchedEffect(key1 = viewModel.showErrorToastChannel) {
        viewModel.showErrorToastChannel.collectLatest { show ->
            if (show) {
                Toast.makeText(
                    context, "Error", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    //Если лист пустой, то будет отображаться progress bar
    if (ListNews.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        //Иначе выводим данные в лист
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(16.dp)
        ) {
            items(ListNews.size) { index ->
                OneNew(ListNews[index])
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }*/
}

//Отрисовка одной новости
/*
@Composable
fun OneNew(res: ResultNews) {
    val imageState = rememberAsyncImagePainter(
        model = Builder(LocalContext.current).data(res.image)
            .size(ORIGINAL).build()
    ).state

    Column(

        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .height(300.dp)
            .fillMaxWidth()
            .background(Color(0xFFB8C1CC))
    ) {

        if (imageState is AsyncImagePainter.State.Error) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (imageState is AsyncImagePainter.State.Success) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = imageState.painter,
                contentDescription = res.name,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Price: ${res.price}$",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = res.description,
            fontSize = 13.sp,
        )

    }
}*/
