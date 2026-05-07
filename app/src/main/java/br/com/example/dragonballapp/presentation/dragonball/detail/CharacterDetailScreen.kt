package br.com.example.dragonballapp.presentation.dragonball.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.example.dragonballapp.presentation.common.UiState
import coil3.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    characterId: Int,
    onBackClick: () -> Unit,
    viewModel: CharacterDetailViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.getCharacterById(characterId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhe") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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

                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Error -> {
                    Text(state.message)
                }

                is UiState.Success -> {

                    val character = state.data

                    Column {

                        AsyncImage(
                            model = character.imageUrl,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )

                        Text(character.name)
                        Text("Raça: ${character.race}")
                        Text("Ki: ${character.ki}")
                        Text("Max Ki: ${character.maxKi}")

                        Spacer(modifier = Modifier.height(16.dp))

                        Text("Transformações:")

                        LazyColumn {

                            items(character.transformations) { t ->

                                Card {

                                    Column {

                                        AsyncImage(
                                            model = t.imageUrl,
                                            contentDescription = null
                                        )

                                        Text(t.name)
                                        Text("Ki: ${t.ki}")
                                    }
                                }
                            }
                        }
                    }
                }

                else -> {}
            }
        }
    }
}