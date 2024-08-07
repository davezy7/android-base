package idmy.davezy.baseproject.core.network.response

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T?): ApiResult<T>()
    data class Error<out T>(val error: ErrorResponse): ApiResult<T>()
}