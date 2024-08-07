package idmy.davezy.baseproject.core.network.base

import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.network.response.ApiResult.Error
import idmy.davezy.baseproject.core.network.response.ApiResult.Success
import idmy.davezy.baseproject.core.network.response.ErrorResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend inline fun <T> callApi(crossinline apiCall: suspend () -> Response<T>): ApiResult<T> =
        withContext(IO) {
            try {
                with(apiCall()) {
                    if (isSuccessful) Success(data = body())
                    else Error(ErrorResponse(code = code(), title = message()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Error(
                    ErrorResponse(
                        code = 0,
                        title = e.message.toString(),
                        message = e.localizedMessage?.toString()
                    )
                )
            }
        }
}