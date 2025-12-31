plugins {
    alias(libs.plugins.gaanaartist.android.feature.api)
    alias(libs.plugins.gaanaartist.android.library.compose)
}

android {
    namespace = "com.shivam.gaanaartist.feature.audience.api"
}

dependencies {
   api(projects.core.navigation)
}