package idmy.davezy.baseproject.data.example_one.repository

import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.network.response.ApiResult.Error
import idmy.davezy.baseproject.core.network.response.ApiResult.Success
import idmy.davezy.baseproject.core.system.model.ExampleModel
import idmy.davezy.baseproject.data.example_one.sources.remote.ExampleOneRemoteDataSource
import javax.inject.Inject

internal class ExampleOneRepositoryImpl @Inject constructor(
    private val remoteSource: ExampleOneRemoteDataSource
) : ExampleOneRepository {

    override suspend fun getExample(): ApiResult<ExampleModel> =
        when (val source = remoteSource.getExample()) {
            is Success -> Success(source.data?.mapToModel())
            is Error -> Error(source.error)
        }

    override suspend fun postExample(
        id: Long,
        request: PostExampleRequest
    ): ApiResult<ExampleModel> = when (val source = remoteSource.postExample(id, request)) {
        is Success -> Success(source.data?.mapToModel())
        is Error -> Error(source.error)
    }
}