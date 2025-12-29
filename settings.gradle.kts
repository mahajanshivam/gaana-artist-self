pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

includeBuild("build-logic")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "GaanaArtistSelf"
include(":app")
include(":core:common")
include(":core:model")
include(":core:data")
include(":core:database")
include(":core:datastore")
include(":core:datastore-proto")
include(":core:designsystem")
include(":core:domain")
include(":core:navigation")
include(":core:network")
include(":core:ui")

include(":feature:login:api")
include(":feature:login:impl")
include(":feature:home:api")
include(":feature:home:impl")
include(":feature:profile:api")
include(":feature:profile:impl")
include(":feature:settings:api")
include(":feature:settings:impl")
include(":feature:music:api")
include(":feature:music:impl")
