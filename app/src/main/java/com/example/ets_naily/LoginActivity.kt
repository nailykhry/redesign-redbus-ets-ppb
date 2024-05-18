package com.example.ets_naily

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    var text by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
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
                .offset(y = (170).dp)
        ){
            Box(modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .zIndex(2f)){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Verifikasi data Anda",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold
                        )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = buildAnnotatedString {
                            append("Belum memiliki akun?")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFFC83C44))) {
                                append(" Daftar")
                            }
                        },
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Box(modifier = Modifier
                        .padding(30.dp, 0.dp)
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Color(0xFFC83C44),
                            shape = RoundedCornerShape(10.dp)
                        )

                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(text = "+62", fontSize = 18.sp)
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.size(40.dp),
                                tint = Color(0xFFC83C44)
                            )
                            TextField(
                                value = text,
                                onValueChange = { newText ->
                                    if (newText.all { it.isDigit() }) {
                                        text = newText
                                    }
                                },
                                label = { Text("Enter your mobile number") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                textStyle = TextStyle(fontSize = 15.sp),
                                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedButton(
                        onClick = { navController.navigate("homepage") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 0.dp)
                            .height(40.dp)
                            .shadow(4.dp, RoundedCornerShape(12.dp)),
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC83C44))
                    ) {
                        Row(){
                            Icon(
                                painter = painterResource(id = R.drawable.akar_icons_whatsapp_fill),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Kirim OTP(Whatsapp)",
                                fontSize = 15.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedButton(
                        onClick = { navController.navigate("homepage") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 0.dp)
                            .height(40.dp)
                            .shadow(4.dp, RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC83C44))
                    ) {
                        Row(){
                            Icon(
                                painter = painterResource(id = R.drawable.sms),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Kirim OTP(SMS)",
                                fontSize = 15.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Atau", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(15.dp))

                    ElevatedButton(
                        onClick = { navController.navigate("homepage") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 0.dp)
                            .height(40.dp)
                            .shadow(2.dp, RoundedCornerShape(10.dp))
                            .border(
                                width = 2.dp,
                                color = Color(0xFFC83C44),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF))
                    ) {
                        Row(){
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "google",
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(15.dp))

                            Text(
                                text = "Continue with Google",
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        modifier = Modifier.padding(30.dp, 0.dp),
                        textAlign = TextAlign.Center,
                        text = buildAnnotatedString {
                            append("Dengan melakukan pemesanan, saya sudah setuju dengan semua ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Light, textDecoration = TextDecoration.Underline, color = Color(0xFFC83C44))) {
                                append(" Syarat dan Ketentuan")
                            }
                            append(" serta Ketentuan Privasi")
                        },
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(1.dp)
                            .background(color = Color(0xFFC83C44))
                    )
                    Text(
                        text = "PUNYA REFERRAL CODE?",
                        color = Color(0xFFC83C44),
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LoginPreview() {
//    LoginScreen()
//}
