package idmy.davezy.baseproject.data.example_one.api

import idmy.davezy.baseproject.core.network.request.PostExampleRequest
import idmy.davezy.baseproject.core.network.response.get.GetExampleResponse
import idmy.davezy.baseproject.core.network.response.post.PostExampleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExampleApi {

    @GET("/get-example")
    suspend fun getExample(): Response<GetExampleResponse>

    @POST("/edit-example/{id}")
    suspend fun postExample(
        @Path("id") id: Long,
        @Body request: PostExampleRequest
    ): Response<PostExampleResponse>
}