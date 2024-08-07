package idmy.davezy.baseproject.core.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idmy.davezy.baseproject.core.system.model.UiState
import idmy.davezy.baseproject.core.system.model.UiState.Error
import idmy.davezy.baseproject.core.system.model.UiState.Initial
import idmy.davezy.baseproject.core.system.model.UiState.Loading
import idmy.davezy.baseproject.core.system.model.UiState.Success
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val coroutineContext = Dispatchers.IO + SupervisorJob()
    private val scope = CoroutineScope(
        coroutineContext +
        CoroutineName("vm_coroutine")
    )

    protected fun <T> Flow<UiState<T>>.collectApi(
        state: MutableStateFlow<UiState<T>>,
        onLoading: (() -> Unit)? = null,
        onError: ((code: Int, errorMsg: String) -> Unit)? = null,
        onSuccess: ((data: T?) -> Unit)? = null,
    ) {
        viewModelScope.launch(coroutineContext) {
            this@collectApi.distinctUntilChanged()
                .collectLatest {
                    state.value = it
                    when (it) {
                        Initial -> Unit
                        Loading -> onLoading?.invoke()
                        is Error -> onError?.invoke(it.code, it.message)
                        is Success -> onSuccess?.invoke(it.data)
                    }
                }
        }
    }

    protected fun cancelJob() = with(viewModelScope) { if (isActive) cancel() }

}