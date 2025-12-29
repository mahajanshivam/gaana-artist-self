plugins {
    alias(libs.plugins.gaanaartist.android.feature.api)
}

android {
    namespace = "com.shivam.gaanaartist.feature.profile.api"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}