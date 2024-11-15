package com.devjamiro.geminichatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatPage(modifier: Modifier) {
    Column(modifier = modifier) {
        AppHeader()
        MessageInput()
    }
}

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.topBar))
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Gemini ChatBot",
            color = Color.White,
            fontSize = 22.sp
        )
    }
}

@Composable
fun MessageInput() {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(value = message,
            onValueChange = { message = it }
        )
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send Message",
                tint = colorResource(id = R.color.topBar)
            )
        }
    }
}









