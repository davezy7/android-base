package idmy.davezy.baseproject.feature.one.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import idmy.davezy.baseproject.core.system.model.UiState.Success
import idmy.davezy.baseproject.feature.one.viewmodel.ExampleViewModel

@Composable
internal fun ExampleScreen(viewModel: ExampleViewModel = hiltViewModel()) = with(viewModel) {

    val example = exampleState.collectAsStateWithLifecycle().value
    val counter = counterState.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) { if (example !is Success) getExample() }
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Counter: $counter",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = Bold,
                ),
                modifier = Modifier.align(alignment = CenterHorizontally)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = { updateCounter(counter + 1) }
            ) {
                Text("Update Counter", style = TextStyle(fontSize = 18.sp, fontWeight = Bold))
            }
        }
    }
}