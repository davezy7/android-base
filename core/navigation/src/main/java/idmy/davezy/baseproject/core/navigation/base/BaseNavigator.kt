package idmy.davezy.baseproject.core.navigation.base

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import idmy.davezy.baseproject.core.navigation.CoreNavigator

abstract class BaseNavigator(val graphRoute: String, val initialRoute: BaseRoute) {

    private lateinit var navController: NavController

    lateinit var coreNavigator: CoreNavigator

    abstract fun registerNavigation(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    )

    fun navigate(route: String) = navController.navigate(route)

    inline fun <reified T: BaseNavigator> get(): T = coreNavigator.navigators.find { it is T } as T

    internal fun buildNavigation(
        coreNavigator: CoreNavigator,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) = with(navGraphBuilder) {
        this@BaseNavigator.navController = navController
        this@BaseNavigator.coreNavigator = coreNavigator
        this.navigation(startDestination = initialRoute.baseRoute, route = graphRoute) {
            registerNavigation(navController = navController, navGraphBuilder = this)
        }
    }
}