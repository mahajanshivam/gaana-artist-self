plugins {
    alias(libs.plugins.gaanaartist.android.library)
    alias(libs.plugins.gaanaartist.hilt)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.shivam.gaanaartist.core.datastore"
}

dependencies {
    implementation(libs.protobuf.kotlin.lite)
    implementation(libs.androidx.dataStore)
    implementation(projects.core.datastoreProto)
    implementation(projects.core.model)

    implementation(projects.core.common)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}