package idmy.davezy.baseproject.core.network.base

import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.system.model.UiState
import idmy.davezy.baseproject.core.system.model.UiState.Error
import idmy.davezy.baseproject.core.system.model.UiState.Loading
import idmy.davezy.baseproject.core.system.model.UiState.Success
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase {
    protected inline fun <T> getResult(crossinline repoCall: suspend () -> ApiResult<T>): Flow<UiState<T>> =
        flow {
            emit(Loading)
            when (val data = repoCall()) {
                is ApiResult.Success -> emit(Success(data.data))
                is ApiResult.Error -> emit(
                    Error(code = data.error.code, message = data.error.message.orEmpty())
                )
            }
        }.distinctUntilChanged().flowOn(IO)
}