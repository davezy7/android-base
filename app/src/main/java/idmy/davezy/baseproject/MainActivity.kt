package idmy.davezy.baseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import idmy.davezy.baseproject.core.navigation.CoreNavigator
import idmy.davezy.baseproject.ui.theme.BaseProjectTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var coreNavigator: CoreNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseProjectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = coreNavigator.initialGraph
                ) {
                    coreNavigator.buildNavigation(
                        navController = navController,
                        navGraphBuilder = this
                    )
                }
            }
        }
    }
}