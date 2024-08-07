package idmy.davezy.baseproject.feature.one.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import idmy.davezy.baseproject.core.navigation.features.FeatureOneNavigator
import idmy.davezy.baseproject.feature.one.navigation.routes.ExampleRoute
import idmy.davezy.baseproject.feature.one.screen.ExampleScreen
import javax.inject.Inject

class FeatureOneNavigatorImpl @Inject constructor() : FeatureOneNavigator(ExampleRoute) {
    override fun registerNavigation(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) = with(navGraphBuilder) {
        ExampleRoute.registerRoute(this) { ExampleScreen() }
    }
}