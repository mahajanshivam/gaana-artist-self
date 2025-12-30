plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.hilt)
    alias(libs.plugins.gaanaartist.android.library.compose)
    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.shivam.gaanaartist.core.navigation"
}

dependencies {

    api(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.savedstate.compose)
    implementation(libs.androidx.lifecycle.viewModel.navigation3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}