plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.hilt)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.shivam.gaanaartist.core.domain"
}

dependencies {

    api(projects.core.data)
    api(projects.core.model)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}