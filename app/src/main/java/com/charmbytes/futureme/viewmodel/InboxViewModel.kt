package com.charmbytes.futureme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charmbytes.futureme.data.CapsuleRepository
import com.charmbytes.futureme.model.Capsule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class InboxViewModel(
    private val repository: CapsuleRepository
) : ViewModel() {

    val allLetters = repository.allLetters

    fun refreshFromServer(token: String) {
        viewModelScope.launch {
            repository.fetchLettersFromServer(token)
        }
    }
}

