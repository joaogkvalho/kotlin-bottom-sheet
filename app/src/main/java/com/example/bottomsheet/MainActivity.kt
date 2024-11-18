package com.example.bottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomsheet.components.sheets.BottomSheetUI
import com.example.bottomsheet.ui.theme.BottomSheetTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomSheetTheme {
                val scope = rememberCoroutineScope()

                val sheetState = rememberModalBottomSheetState(
                    skipPartiallyExpanded = true,
                    confirmValueChange = { true }
                )
                var showBottomSheet by remember { mutableStateOf(false) }

                Scaffold(
                    content = { contentPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(contentPadding),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    showBottomSheet = true
                                },
                                modifier = Modifier
                                    .height(58.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
                                content = {
                                    Text(
                                        text = "Abrir",
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

                        if (showBottomSheet) {
                            ModalBottomSheet(
                                onDismissRequest = {
                                    showBottomSheet = false
                                },
                                sheetState = sheetState,
                                dragHandle = {
                                    BottomSheetDefaults.DragHandle(
                                        width = 38.dp,
                                        height = 3.dp,
                                        color = Color(0xFFE0E0E0)
                                    )
                                },
                                content = {
                                    BottomSheetUI(
                                        onDismiss = {
                                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                                if (!sheetState.isVisible) {
                                                    showBottomSheet = false
                                                }
                                            }
                                        }
                                    )
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}