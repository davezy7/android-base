package idmy.davezy.baseproject.data.example_one.use_case.post

import idmy.davezy.baseproject.core.network.base.BaseUseCase
import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.system.model.ExampleModel
import idmy.davezy.baseproject.core.system.model.UiState
import idmy.davezy.baseproject.data.example_one.repository.ExampleOneRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostExampleUseCaseImpl @Inject constructor(private val repo: ExampleOneRepository) :
    PostExampleUseCase, BaseUseCase() {
    override fun invoke(id: Long, name: String, price: Long): Flow<UiState<ExampleModel>> =
        getResult { repo.postExample(id = id, request = PostExampleRequest(name, price)) }
}