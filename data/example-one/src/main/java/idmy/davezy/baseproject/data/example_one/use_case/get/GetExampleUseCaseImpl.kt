package idmy.davezy.baseproject.data.example_one.use_case.get

import idmy.davezy.baseproject.core.network.base.BaseUseCase
import idmy.davezy.baseproject.data.example_one.repository.ExampleOneRepository
import javax.inject.Inject

class GetExampleUseCaseImpl @Inject constructor(private val repo: ExampleOneRepository) :
    GetExampleUseCase, BaseUseCase() {
    override operator fun invoke() = getResult { repo.getExample() }
}