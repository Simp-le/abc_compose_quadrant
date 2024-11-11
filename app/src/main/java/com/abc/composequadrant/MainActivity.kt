package com.abc.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abc.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AllQuadrants(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun AllQuadrants(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.text_composable),
                description = stringResource(id = R.string.text_description),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.image_composable),
                description = stringResource(id = R.string.image_description),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.row_composable),
                description = stringResource(id = R.string.row_description),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.column_composable),
                description = stringResource(id = R.string.column_description),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        // WE USE the transmitted modifier, which we previously set to weight(1f)!!!
        // You can't put weight(1f) here because the function is not in Row or Column,
        // that is, weight is not needed here either
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(title, modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
        Text(description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    ComposeQuadrantTheme {
        AllQuadrants(Modifier.fillMaxSize())
    }
}