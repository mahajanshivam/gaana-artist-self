plugins {
    alias(libs.plugins.gaanaartist.android.feature.api)
}

android {
    namespace = "com.shivam.gaanaartist.feature.home.api"
}

dependencies {
    api(projects.core.navigation)
}