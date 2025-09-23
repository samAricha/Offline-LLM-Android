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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            name = "GitHubPackagesCactus"
            url = uri("https://maven.pkg.github.com/cactus-compute/cactus-kotlin")
            credentials {
                val props = java.util.Properties().apply {
                    val propsFile = File(rootDir, "local.properties")
                    if (propsFile.exists()) {
                        load(propsFile.inputStream())
                    }
                }
                username = props.getProperty("github.username") ?: System.getenv("GITHUB_ACTOR")
                password = props.getProperty("github.token") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

rootProject.name = "Offline LLM"
include(":app")
 