plugins {
    `kotlin-dsl`
}

//repositories {
//    google()
//    mavenCentral()
//}

dependencies {
    implementation("com.android.tools.build:gradle:8.7.0") // or your AGP version
}

// Add this block to register your convention plugin
gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "gaana.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}
