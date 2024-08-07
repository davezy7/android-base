package idmy.davezy.baseproject.core.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import idmy.davezy.baseproject.core.navigation.CoreNavigator
import idmy.davezy.baseproject.core.navigation.features.FeatureOneNavigator

@Module
@InstallIn(SingletonComponent::class)
class CoreNavigationModule {

    @Provides
    fun provideCoreNavigation(
        featureOneNavigator: FeatureOneNavigator
    ) = CoreNavigator(
        listOf(
            featureOneNavigator
        )
    )
}