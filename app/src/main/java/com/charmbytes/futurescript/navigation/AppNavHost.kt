package com.charmbytes.futurescript.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.charmbytes.futurescript.feature.auth.*
import com.charmbytes.futurescript.feature.compose.*
import com.charmbytes.futurescript.feature.inbox.InboxScreen
import com.charmbytes.futurescript.feature.detail.LetterDetailScreen
@Composable
fun AppNavHost(nav: NavHostController) {
    NavHost(navController = nav, startDestination = Routes.Welcome) {
        composable(Routes.Welcome) { WelcomeScreen(onBegin = { nav.navigate(Routes.SignIn) }) }
        composable(Routes.SignIn) { SignInScreen(
            onLogin = { nav.navigate(Routes.Inbox) },
            onGoSignUp = { nav.navigate(Routes.SignUp) }
        )}
        composable(Routes.SignUp) { SignUpScreen(onSignedUp = { nav.navigate(Routes.AccountCreated) }) }
        composable(Routes.AccountCreated) { AccountCreatedScreen(onLoginPage = { nav.navigate(Routes.SignIn) }) }
        composable(Routes.Inbox) { InboxScreen(onCompose = { nav.navigate(Routes.Compose) }, onOpen = { id ->
            nav.navigate(Routes.detail(id))
        }) }
        composable(Routes.Compose) { ComposeLetterScreen(onSent = { nav.navigate(Routes.Sent) }, onBack = { nav.popBackStack() }) }
        composable(Routes.Sent) { SendConfirmationScreen(onHome = { nav.navigate(Routes.Inbox) }) }
        composable(Routes.Detail) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: -1L
            LetterDetailScreen(id = id, onBack = { nav.popBackStack() })
        }
    }
}
