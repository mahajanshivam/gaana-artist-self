plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.hilt)
}
android {
    namespace = "com.shivam.gaanaartist.core.network"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}