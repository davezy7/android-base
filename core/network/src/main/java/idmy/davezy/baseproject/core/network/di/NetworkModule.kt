package idmy.davezy.baseproject.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import idmy.davezy.baseproject.core.network.NetworkClient
import idmy.davezy.baseproject.core.network.NetworkInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkClient(interceptor: NetworkInterceptor): NetworkClient = NetworkClient(
        OkHttpClient.Builder().apply {
            val timeout = 30L
            val logging = interceptor.createLogging()
            addInterceptor(interceptor)
            addInterceptor(logging)
            callTimeout(timeout, SECONDS)
            writeTimeout(timeout, SECONDS)
            readTimeout(timeout, SECONDS)
        }.build()
    )
}