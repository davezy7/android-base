package idmy.davezy.baseproject.core.network

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import javax.inject.Inject

internal class NetworkInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Chain) = with(chain.request()) {
        return@with chain.proceed(
            newBuilder().apply {
                addHeader("Content-Type", "application/json")
                method(method, body)
            }.build()
        )
    }

    fun createLogging() = HttpLoggingInterceptor().apply { level = BODY }
}