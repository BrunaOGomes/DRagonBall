package br.com.example.dragonballapp.presentation.navigation

// Manter seu package
import br.com.example.dragonballapp.presentation.dragonball.search.CharacterSearchScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.example.dragonballapp.presentation.dragonball.detail.CharacterDetailScreen
import br.com.example.dragonballapp.presentation.dragonball.list.CharacterListScreen
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.LIST
    ) {

        composable(AppRoutes.LIST) {

            CharacterListScreen(
                onSearchClick = {
                    navController.navigate(AppRoutes.SEARCH)
                },
                onCharacterClick = { id ->
                    navController.navigate(
                        AppRoutes.detail(id)
                    )
                }
            )
        }

        composable(AppRoutes.SEARCH) {

            CharacterSearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSearchClick = { id ->
                    navController.navigate(
                        AppRoutes.detail(id)
                    )
                }
            )
        }

        composable(
            route = AppRoutes.DETAIL,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {

            val id =
                it.arguments?.getInt("id") ?: 1

            CharacterDetailScreen(
                characterId = id,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}


