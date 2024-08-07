package idmy.davezy.baseproject.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class NetworkClient @Inject constructor(private val client: OkHttpClient) {
    fun <T> create(defClass: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(getConverter())
            .baseUrl("https://google.com")
            .client(client)
            .build()
        return retrofit.create(defClass)
    }

    private fun getConverter() = MoshiConverterFactory.create()
}