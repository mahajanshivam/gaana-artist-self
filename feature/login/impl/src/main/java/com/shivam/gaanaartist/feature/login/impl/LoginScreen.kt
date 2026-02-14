package com.shivam.gaanaartist.feature.login.impl

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    loginDone: () -> Unit = {}
) {
    Log.d("shivam", "LoginScreen: ")

    Box(modifier = Modifier.fillMaxSize()) {

        Text("Login Screen")

        OutlinedButton(
            onClick = loginDone
        ) {

            Text("Login")
        }
    }
}

@Composable
fun HomeScreenPreview() {
    LoginScreen()
}
