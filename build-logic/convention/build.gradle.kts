import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
//    alias(libs.plugins.android.lint)
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

tasks.withType<KotlinCompile>() {
    compilerOptions {
        languageVersion.set(KotlinVersion.KOTLIN_2_1)
    }
}

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

        register("androidLibrary") {
            id = libs.plugins.gaanaartist.android.library.asProvider().get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = libs.plugins.gaanaartist.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("jvmLibrary") {
            id = libs.plugins.gaanaartist.jvm.library.get().pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("androidLint") {
            id = libs.plugins.gaanaartist.android.lint.get().pluginId
            implementationClass = "AndroidLintConventionPlugin"
        }

        register("hilt") {
            id = libs.plugins.gaanaartist.hilt.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }
    }
}
