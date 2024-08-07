package idmy.davezy.baseproject.data.example_one.use_case.post

import idmy.davezy.baseproject.core.system.model.ExampleModel
import idmy.davezy.baseproject.core.system.model.UiState
import kotlinx.coroutines.flow.Flow

interface PostExampleUseCase {
    operator fun invoke(id: Long, name: String, price: Long): Flow<UiState<ExampleModel>>
}