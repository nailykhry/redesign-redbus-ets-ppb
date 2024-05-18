package com.example.ets_naily
import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.text.SimpleDateFormat
import java.util.Date


@Composable
fun Homepage(navController: NavController){
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFDCC62),
            Color(0xFFFFFFFF)
        )
    )

    var asal by remember { mutableStateOf("") }
    var tujuan by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }

    var selectedDate by remember { mutableStateOf<Date?>(null) }
    var isDatePickerVisible by remember { mutableStateOf(false) }
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy") }


    Scaffold(
        bottomBar = { BottomNavBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFEF4F4))
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
        ) {
            Image(
                painter = painterResource(id = R.drawable.homepage_frame),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(0f),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
                    .offset(y = (-60).dp)
                    .padding(20.dp)
                    .shadow(4.dp, RoundedCornerShape(10.dp))

            ){
                Box(modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .zIndex(2f)
                    .height(250.dp)
                ) {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                        ) {
                            TextField(
                                value = asal,
                                onValueChange = { asal = it },
                                label = { Text("Asal") },
                                modifier = Modifier
                                    .weight(1f)
                                    .background(Color.White),

                            )
                            Icon(
                                painter = painterResource(id = R.drawable.mi_switch),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically),
                                tint = Color(0xFFC83C44)
                            )
                            TextField(
                                value = tujuan,
                                onValueChange = { tujuan = it },
                                label = { Text("Tujuan") },
                                modifier = Modifier.weight(1f)
                            )
                        }

                        TextField(
                            value = tanggal,
                            onValueChange = { tanggal = it},
                            label = { Text("Tanggal Perjalanan") },
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        )

                        ElevatedButton(
                            onClick = { navController.navigate("busList") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp, 20.dp)
                                .height(45.dp)
                                .shadow(4.dp, RoundedCornerShape(12.dp)),
                            shape = RoundedCornerShape(30),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC83C44))
                        ) {
                            Row{
                                Icon(
                                    painter = painterResource(id = R.drawable.a_),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Cari Bis",
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                Text(text = "Promo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(20.dp, 0.dp)
                        .offset(y = (-60).dp)
                )
                Text(text = "Lihat semua",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(20.dp, 0.dp)
                        .offset(y = (-55).dp),
                    color = (Color(0xFFC83C44)),
                    textDecoration = TextDecoration.Underline
                )
            }


            Spacer(modifier =  Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(20.dp, 0.dp)
                    .offset(y = (-60).dp)
                    .background(brush=gradient, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFC83C44),
                        shape = RoundedCornerShape(10.dp)
                    )
            ){
                Row{
                    Image(
                        painter = painterResource(id = R.drawable.promo),
                        contentDescription = "promo image",
                        modifier = Modifier.size(120.dp).padding(20.dp)
                        )
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Dapatkan Diskon 25%", fontWeight = FontWeight.Bold)
                        Text(text="Valid hingga 31 Des 2024")
                        Spacer(modifier = Modifier.height(20.dp))
                        ElevatedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(125.dp)
                                .height(30.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC83C44))
                        ) {
                            Text(
                                text = "Klaim Promo",
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, 0.dp)
                    .height(55.dp)
                    .offset(y = (-30).dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFC83C44),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Row{
                        Icon(
                            painter = painterResource(id = R.drawable.a_mage_note_text_fill),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFFC83C44)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Riwayat Booking",
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }

                    Row{
                        Icon(
                            painter = painterResource(id = R.drawable.a_material_symbols_developer_guide_rounded),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFFC83C44)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Panduan",
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Text(
                text = "Kenapa redBus?",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(20.dp)
            )

            Row(modifier = Modifier.padding(20.dp, 0.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.material_symbols_event_available),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Color(0xFFC83C44)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Tiket tersedia pada hampir semua rute", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Hemat waktu dan tenaga")
                }
            }

            Row(modifier = Modifier.padding(20.dp, 10.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.tdesign_money),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Color(0xFFC83C44)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Pembayaran yang aman", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Tersedia pilihan pembayaran cashless")
                }
            }
           Box(modifier = Modifier.height(150.dp)){}
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomepagePreview() {
//    Homepage()
//}
