package com.example.bottomsheet.components.sheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomsheet.R

@Composable
fun BottomSheetUI(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Excluir",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 28.8.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF2196F3)
            )
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 24.dp),
            color = Color(0xFFEEEEEE)
        )

        Text(
            text = "Tem certeza de que deseja excluir o download deste jogo?",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF424242),
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.game),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(130.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
            ) {
                Text(
                    text = "League of Legends",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 21.6.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF212121)
                    )
                )

                Text(
                    text = "Pc - Windows",
                    modifier = Modifier
                        .padding(vertical = 12.dp),
                    style = TextStyle(
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF424242)
                    )
                )

                Text(
                    text = "1,4 GB",
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFF2196F3).copy(alpha = 0.1f))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF2196F3)
                    )
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 24.dp),
            color = Color(0xFFEEEEEE)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .height(58.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.1f),
                    contentColor = Color(0xFF2196F3)
                ),
                content = {
                    Text(
                        text = "Cancelar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp,
                            fontWeight = FontWeight(700),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .height(58.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                ),
                content = {
                    Text(
                        text = "Sim, excluir",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp,
                            fontWeight = FontWeight(700),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                }
            )
        }
    }
}