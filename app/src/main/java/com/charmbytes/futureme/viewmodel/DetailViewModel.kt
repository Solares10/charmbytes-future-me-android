package com.charmbytes.futureme.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charmbytes.futureme.data.CapsuleRepository
import com.charmbytes.futureme.model.Capsule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: CapsuleRepository
): ViewModel() {

    private val _letter = MutableStateFlow<Capsule?>(null)
    val letter: StateFlow<Capsule?> = _letter

    fun loadLetter(id: String) {
        viewModelScope.launch {
            _letter.value = repository.getLetterByID(id)
        }
    }

    fun deleteLetter(id: String) {
        viewModelScope.launch {
            repository.deleteLetter(id)
        }
    }
}
