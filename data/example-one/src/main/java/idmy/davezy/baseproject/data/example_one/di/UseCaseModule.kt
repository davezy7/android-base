package idmy.davezy.baseproject.data.example_one.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import idmy.davezy.baseproject.data.example_one.use_case.get.GetExampleUseCase
import idmy.davezy.baseproject.data.example_one.use_case.get.GetExampleUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetExampleUseCase(impl: GetExampleUseCaseImpl): GetExampleUseCase
}