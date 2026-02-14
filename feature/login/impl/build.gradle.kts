plugins {
    alias(libs.plugins.gaanaartist.android.feature.impl)
    alias(libs.plugins.gaanaartist.android.library.compose)
}

android {
    namespace = "com.shivam.gaanaartist.feature.login.impl"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(projects.feature.home.api)
    implementation(projects.feature.login.api)
    implementation(projects.feature.onboarding.api)

}