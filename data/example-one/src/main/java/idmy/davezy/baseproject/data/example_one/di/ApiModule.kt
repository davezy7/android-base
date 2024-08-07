package idmy.davezy.baseproject.data.example_one.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import idmy.davezy.baseproject.core.network.NetworkClient
import idmy.davezy.baseproject.data.example_one.api.ExampleApi
import idmy.davezy.baseproject.data.example_one.repository.ExampleOneRepository
import idmy.davezy.baseproject.data.example_one.repository.ExampleOneRepositoryImpl
import idmy.davezy.baseproject.data.example_one.sources.local.ExampleOneLocalDataSource
import idmy.davezy.baseproject.data.example_one.sources.local.ExampleOneLocalDataSourceImpl
import idmy.davezy.baseproject.data.example_one.sources.remote.ExampleOneRemoteDataSource
import idmy.davezy.baseproject.data.example_one.sources.remote.ExampleOneRemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideExampleApi(client: NetworkClient): ExampleApi = client.create(ExampleApi::class.java)

    @Provides
    fun provideExampleOneRemoteDataSource(api: ExampleApi): ExampleOneRemoteDataSource =
        ExampleOneRemoteDataSourceImpl(api)

    @Provides
    fun provideExampleOneLocalDataSource(): ExampleOneLocalDataSource =
        ExampleOneLocalDataSourceImpl()

    @Provides
    fun provideExampleOneRepository(remoteDataSource: ExampleOneRemoteDataSource): ExampleOneRepository =
        ExampleOneRepositoryImpl(remoteDataSource)
}