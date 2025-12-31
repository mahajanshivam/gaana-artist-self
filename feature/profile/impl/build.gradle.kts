plugins {
    alias(libs.plugins.gaanaartist.android.feature.impl)
    alias(libs.plugins.gaanaartist.android.library.compose)
}

android {
    namespace = "com.shivam.gaanaartist.feature.profile.impl"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(projects.feature.profile.api)
    implementation(projects.core.navigation)
}