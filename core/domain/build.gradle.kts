plugins {
    alias(libs.plugins.gaanaartist.android.library)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.shivam.gaanaartist.core.domain"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}