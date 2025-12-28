import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.shivam.gaanaartist.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

//tasks.withType<KotlinCompile>().configureEach {
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//}

dependencies {
    // Add dependencies required for writing your plugins
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradleApiPlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)

//    compileOnly(libs.firebase.crashlytics.gradlePlugin)
//    compileOnly(libs.firebase.performance.gradlePlugin)
//    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.gaanaartist.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.gaanaartist.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("jvmLibrary") {
            id = libs.plugins.gaanaartist.jvm.library.get().pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("androidLint") {
            id = libs.plugins.gaanaartist.android.lint.get().pluginId
            implementationClass = "AndroidLintConventionPlugin"
        }
    }
}
