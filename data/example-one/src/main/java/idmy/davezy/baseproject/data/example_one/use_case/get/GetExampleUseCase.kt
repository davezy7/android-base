package idmy.davezy.baseproject.data.example_one.use_case.get

import idmy.davezy.baseproject.core.system.model.ExampleModel
import idmy.davezy.baseproject.core.system.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetExampleUseCase {
    operator fun invoke(): Flow<UiState<ExampleModel>>
}