package com.example.ets_naily

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun BusList(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        var currentDate by remember { mutableStateOf(LocalDate.now()) }
        val dateFormatter = DateTimeFormatter.ofPattern("dd MMM")

        // Define the logic for previous and next day clicks
        fun previousDayClick() {
            currentDate = currentDate.minusDays(1)
        }

        fun nextDayClick() {
            currentDate = currentDate.plusDays(1)
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFC63837))
            .padding(20.dp)
        ){
            Row(modifier = Modifier) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "ArrowBack",
                    modifier = Modifier.size(40.dp).clickable{ navController.navigate("homepage")},
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Surabaya", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = "ke Temanggung", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(60.dp))
                Row {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "ArrowBack",
                        modifier = Modifier.size(20.dp).clickable{ previousDayClick() },
                        tint = Color.White
                    )
                    Text(text = currentDate.format(dateFormatter), color = Color.White)
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "ArrowBack",
                        modifier = Modifier.size(20.dp).clickable{ nextDayClick() },
                        tint = Color.White
                    )
                }
            }
        }

        //BOX ISI CARD
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) 
            ) {
            Text(
                text = "15 Bis Ditemukan",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(20.dp))
            for (i in 1..15) {
                Box(
                    modifier = Modifier
                        .padding(20.dp, 0.dp)
                        .fillMaxWidth()
                        .height(170.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .border(
                            width = 2.dp,
                            color = Color(0xFFC83C44),
                            shape = RoundedCornerShape(10.dp)
                        )
                ){
                    Column(
                        modifier = Modifier
                            .padding(25.dp, 0.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.obl),
                            contentDescription ="mitra",
                            modifier = Modifier.size(60.dp))
                        Spacer(modifier = Modifier.height(3.dp))
                        Row {
                            Text(text="06.00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text="-18.10", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(90.dp))
                            Text(text="Rp 195.000", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
                                modifier = Modifier.offset(y = (-10).dp))
                        }
                        Row {
                            Text(text="12h 00m", fontWeight = FontWeight.Light, fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text="40 dari 40 kursi tersedia", color = Color(0xFFFC601D), fontWeight = FontWeight.Light, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Text(text="Safari Dharma Raya", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text=", Executive", fontSize = 16.sp)
                        }
                        Text(text = "Medaeng(redBus Lounge)", fontSize = 14.sp)
                        Text(text = "Terminal Temanggung", fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
