package idmy.davezy.baseproject.data.example_one.sources.remote

import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.network.base.BaseDataSource
import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.network.response.get.GetExampleResponse
import idmy.davezy.baseproject.core.network.response.post.PostExampleResponse
import idmy.davezy.baseproject.data.example_one.api.ExampleApi
import javax.inject.Inject

internal class ExampleOneRemoteDataSourceImpl @Inject constructor(private val api: ExampleApi) :
    ExampleOneRemoteDataSource, BaseDataSource() {

    override suspend fun getExample(): ApiResult<GetExampleResponse> = callApi { api.getExample() }

    override suspend fun postExample(
        id: Long,
        request: PostExampleRequest
    ): ApiResult<PostExampleResponse> = callApi { api.postExample(id, request) }
}