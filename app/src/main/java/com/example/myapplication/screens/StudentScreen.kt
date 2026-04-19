package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // CRITICAL: Import this exact one
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.components.AppCard
import com.example.myapplication.viewmodel.AttendanceViewModel
import com.example.myapplication.ui.theme.*

@Composable
fun StudentScreen(viewModel: AttendanceViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCream)
            .padding(16.dp)
    ) {
        Text(
            text = "Your Performance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.subjectAttendance) { subject ->
                AppCard {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row {
                            Text(
                                text = subject.name,
                                modifier = Modifier.weight(1f),
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )


                            val color = if (subject.percentage < 75) DangerRed else PrimaryGreen

                            Text(
                                text = "${subject.percentage.toInt()}%",
                                color = color,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "Attended: ${subject.attended}/${subject.total}",
                            color = TextSecondary,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}