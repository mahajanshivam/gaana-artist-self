package com.shivam.gaanaartist.feature.onboarding.impl

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreen(onBoardingCompleted: () -> Unit = {}) {

    Text("Onboarding Screen")

    OutlinedButton(
        onClick = onBoardingCompleted
    ) {
        Text("onboarding complete")
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {

}