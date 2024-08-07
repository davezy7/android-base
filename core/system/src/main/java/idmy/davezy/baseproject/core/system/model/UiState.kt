package idmy.davezy.baseproject.core.system.model

sealed class UiState<out T>() {
    data class Success<T>(val data: T?) : UiState<T>()
    data class Error<T>(val code: Int, val message: String) : UiState<T>()
    data object Loading: UiState<Nothing>()
    data object Initial: UiState<Nothing>()
}
