plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.hilt)
    alias(libs.plugins.gaanaartist.android.library.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.shivam.gaanaartist.core.navigation"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}