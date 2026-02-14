plugins {
    alias(libs.plugins.gaanaartist.android.feature.impl)
    alias(libs.plugins.gaanaartist.android.library.compose)
}

android {
    namespace = "com.shivam.gaanaartist.feature.onboarding.impl"
}

dependencies {
    implementation(projects.feature.home.api)
    implementation(projects.feature.onboarding.api)
}