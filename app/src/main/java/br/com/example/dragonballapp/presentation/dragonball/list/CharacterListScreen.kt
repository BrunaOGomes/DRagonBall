package br.com.example.dragonballapp.presentation.dragonball.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.example.dragonballapp.presentation.common.UiState
import org.koin.androidx.compose.koinViewModel
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    onCharacterClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    viewModel: CharacterListViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dragon Ball") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            when (val state = uiState) {

                UiState.Initial -> {}

                UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is UiState.Error -> {
                    Text(
                        text = state.message,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is UiState.Success -> {

                    LazyColumn {
                        items(state.data.size) { index ->

                            val character = state.data[index]

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        onCharacterClick(character.id)
                                    }
                            ) {

                                Row(modifier = Modifier.padding(8.dp)) {

                                    AsyncImage(
                                        model = character.imageUrl,
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp)
                                    )

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Text(
                                        text = character.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier.alignByBaseline()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}