package idmy.davezy.baseproject.data.example_one.sources.remote

import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.network.response.get.GetExampleResponse
import idmy.davezy.baseproject.core.network.response.post.PostExampleResponse

interface ExampleOneRemoteDataSource {
    suspend fun getExample(): ApiResult<GetExampleResponse>
    suspend fun postExample(id: Long, request: PostExampleRequest): ApiResult<PostExampleResponse>
}