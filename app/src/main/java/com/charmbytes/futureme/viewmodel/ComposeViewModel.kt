package com.charmbytes.futureme.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModeScope
import com.charmbytes.futureme.data.CapsuleRepository
import com.charmbytes.futureme.model.Capsule
import kotlin.coroutines.launch

class ComposeViewModel(
    private val repository: CapsuleRepository
): ViewModel() {

    fun sendLetter(token: String, letter: Capsule) {
        viewModelScope.launch {
            repository.sendLetterToServer(token, letter)
        }
    }

    fun saveLetterLocally(letter: Capsule) {
        viewModelScope.launch {
            repository.insertLetter(letter)
        }
    }
}
