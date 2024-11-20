package com.devjamiro.geminichatbot

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constants.apiKey
    )

    fun sendMessage(question: String) {
        viewModelScope.launch {
            val chat = generativeModel.startChat()
            val response = chat.sendMessage(question)
            Log.i("ChatViewModel", "Response: ${response.text.toString()}")
        }
    }
}