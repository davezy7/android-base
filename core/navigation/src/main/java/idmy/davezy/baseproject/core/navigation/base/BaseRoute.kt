package idmy.davezy.baseproject.core.navigation.base

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

abstract class BaseRoute(
    private val route: String,
    private val args: List<NamedNavArgument> = listOf()
) {
    val baseRoute = route + args.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }

    protected fun buildNavRoute(navArgs: List<Pair<String, Any?>> = listOf()): String =
        route + navArgs.joinToString(separator = "&", prefix = "?") { "${it.first}=${it.second}" }

    open fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        content: @Composable (NavBackStackEntry) -> Unit
    ) = with(navGraphBuilder) {
        composable(route = baseRoute, arguments = args, content = content)
    }
}
