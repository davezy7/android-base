package idmy.davezy.baseproject.core.network.response

data class ErrorResponse(
    val code: Int,
    val title: String,
    val message: String? = null
)
