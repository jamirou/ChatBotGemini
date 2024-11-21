package com.devjamiro.geminichatbot

import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devjamiro.geminichatbot.ui.theme.ModelMessage
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import com.devjamiro.geminichatbot.ui.theme.AndroidColor
import com.devjamiro.geminichatbot.ui.theme.BorderColor
import com.devjamiro.geminichatbot.ui.theme.DarkBackground
import com.devjamiro.geminichatbot.ui.theme.TextColorModel
import com.devjamiro.geminichatbot.ui.theme.TextColorUser
import com.devjamiro.geminichatbot.ui.theme.UserMessage
@Composable
fun ChatPage(modifier: Modifier, viewModel: ChatViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)  // Usar DarkBackground
    ) {
        AppHeader()
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            MessageList(
                modifier = Modifier.fillMaxSize(),
                messageList = viewModel.messageList
            )
        }
        MessageInput(
            onMessageSend = { viewModel.sendMessage(it) }
        )
    }
}

@Composable
fun MessageList(modifier: Modifier = Modifier, messageList: List<MessageModel>) {
    if (messageList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.ic_android),
                contentDescription = "Question answer icon",
                tint = AndroidColor
            )
            Text("Preguuuuntame", fontSize = 22.sp, color = Color.White)
        }
    } else {
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ) {
            items(messageList.reversed()) {
                MessageRow(messageModel = it)
            }
        }
    }
}

@Composable
fun MessageRow(messageModel: MessageModel) {
    val isModel = messageModel.role == "model"
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .align(
                            if (isModel) Alignment.BottomStart else Alignment.BottomEnd
                        )
                        .padding(
                            start = if (isModel) 8.dp else 70.dp,
                            end = if (isModel) 70.dp else 8.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        )
                        .clip(RoundedCornerShape(48f))
                        .background(if (isModel) ModelMessage else UserMessage)
                        .border(2.dp, BorderColor, RoundedCornerShape(48f))
                        .padding(16.dp)
                ) {
                    SelectionContainer {
                        Text(
                            text = messageModel.message,
                            fontWeight = FontWeight.W500,
                            color = if (isModel) TextColorModel else TextColorUser
                        )
                    }
                }
            }
        }
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
            text = "Gemini ChatBot test 1",
            color = Color.White,
            fontSize = 22.sp
        )
    }
}

@Composable
fun MessageInput(onMessageSend: (String) -> Unit) {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = message,
            onValueChange = { message = it },
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
        )
        IconButton(onClick = {
            if (message.isNotEmpty()) {
                onMessageSend(message)
                message = ""
            }
        }) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send Message",
                tint = colorResource(id = R.color.topBar)
            )
        }
    }
}