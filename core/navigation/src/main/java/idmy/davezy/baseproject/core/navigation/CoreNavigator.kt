package idmy.davezy.baseproject.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import idmy.davezy.baseproject.core.navigation.base.BaseNavigator
import javax.inject.Inject

class CoreNavigator @Inject constructor(val navigators: List<BaseNavigator>) {

    val initialGraph = navigators.first().graphRoute

    fun buildNavigation(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navigators.forEach {
            it.buildNavigation(
                coreNavigator = this,
                navController = navController,
                navGraphBuilder = navGraphBuilder
            )
        }
    }
}