package idmy.davezy.baseproject.core.network.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostExampleRequest(
    @Json(name = "name") val name: String,
    @Json(name = "product_price") val productPrice: Long
)
