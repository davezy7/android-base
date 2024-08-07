package idmy.davezy.baseproject.feature.one.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import idmy.davezy.baseproject.core.system.model.ExampleModel
import idmy.davezy.baseproject.core.system.model.UiState
import idmy.davezy.baseproject.core.system.model.UiState.Initial
import idmy.davezy.baseproject.core.ui.base.BaseViewModel
import idmy.davezy.baseproject.data.example_one.use_case.get.GetExampleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ExampleViewModel @Inject constructor(
    private val getExampleUseCase: GetExampleUseCase
) : BaseViewModel() {

    private val _exampleState = MutableStateFlow<UiState<ExampleModel>>(Initial)
    val exampleState = _exampleState.asStateFlow()

    private val _counterState = MutableStateFlow(0)
    val counterState = _counterState.asStateFlow()

    fun getExample() {
        getExampleUseCase().collectApi(state = _exampleState)
    }

    fun updateCounter(value: Int) = _counterState.update { value }
}