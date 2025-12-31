plugins {
    alias(libs.plugins.gaanaartist.android.application)
    alias(libs.plugins.gaanaartist.android.application.compose)
    alias(libs.plugins.gaanaartist.android.application.flavors)
    alias(libs.plugins.gaanaartist.hilt)
}

android {
    namespace = "com.shivam.gaanaartist"

    defaultConfig {
        applicationId = "com.shivam.gaanaartist"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.navigation3.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(projects.core.model)
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)

    implementation(projects.feature.home.api)
    implementation(projects.feature.home.impl)
    implementation(projects.feature.music.api)
    implementation(projects.feature.music.impl)
    implementation(projects.feature.audience.api)
    implementation(projects.feature.audience.impl)
    implementation(projects.feature.canvas.api)
    implementation(projects.feature.canvas.impl)
    implementation(projects.feature.profile.api)
    implementation(projects.feature.profile.impl)
    implementation(projects.feature.settings.api)
    implementation(projects.feature.settings.impl)

    implementation(libs.androidx.core.splashscreen)

}