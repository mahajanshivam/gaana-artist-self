plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.android.library.compose)
}
android {
    namespace = "com.shivam.gaanaartist.core.ui"
}
dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}