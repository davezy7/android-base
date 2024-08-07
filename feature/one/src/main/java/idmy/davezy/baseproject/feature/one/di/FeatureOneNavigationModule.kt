package idmy.davezy.baseproject.feature.one.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import idmy.davezy.baseproject.core.navigation.features.FeatureOneNavigator
import idmy.davezy.baseproject.feature.one.navigation.FeatureOneNavigatorImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureOneNavigationModule {

    @Binds
    abstract fun bindsFeatureOneNavigation(impl: FeatureOneNavigatorImpl): FeatureOneNavigator
}