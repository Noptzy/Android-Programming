package com.learn.abcd.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.abcd.model.Quote
import com.learn.abcd.repository.QouteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface QuoteUiState {
    object Loading : QuoteUiState
    data class Success(val quote: Quote) : QuoteUiState
    data class Error(val message: String?) : QuoteUiState
}

class QuoteViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<QuoteUiState>(QuoteUiState.Loading)
    val uiState: StateFlow<QuoteUiState> = _uiState.asStateFlow()

    fun fetchNewQoute() {
        viewModelScope.launch {
            _uiState.value = QuoteUiState.Loading
            try {
                val quote = QouteRepository().getRandomQuote()
                _uiState.value = QuoteUiState.Success(quote)
            } catch (e: Exception) {
                _uiState.value = QuoteUiState.Error(e.message ?: "Gagal Memuat Qoute")
            }
        }
    }
}