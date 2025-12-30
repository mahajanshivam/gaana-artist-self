plugins {
    alias(libs.plugins.gaanaartist.android.feature.api)
}

android {
    namespace = "com.shivam.gaanaartist.feature.music.api"
}

dependencies {
    api(projects.core.navigation)
}