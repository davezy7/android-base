package idmy.davezy.baseproject.data.example_one.repository

import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.network.response.ApiResult
import idmy.davezy.baseproject.core.system.model.ExampleModel

interface ExampleOneRepository {
    suspend fun getExample(): ApiResult<ExampleModel>
    suspend fun postExample(id: Long, request: PostExampleRequest): ApiResult<ExampleModel>
}