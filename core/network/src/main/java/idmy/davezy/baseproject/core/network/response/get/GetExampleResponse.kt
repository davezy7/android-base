package idmy.davezy.baseproject.core.network.response.get

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import idmy.davezy.baseproject.core.system.model.ExampleModel

@JsonClass(generateAdapter = true)
data class GetExampleResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "product_price") val productPrice: Long
) {
    fun mapToModel() = ExampleModel(
        id = id,
        name = name,
        productPrice = productPrice
    )
}
