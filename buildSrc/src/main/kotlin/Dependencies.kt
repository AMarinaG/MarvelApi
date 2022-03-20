object BuildPlugins {
    val androidApp by lazy { "com.android.application" }
    val androidLib by lazy { "com.android.library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
    val kotlinJvm by lazy { "org.jetbrains.kotlin.jvm" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt" }
}

object Buildscript {
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val secretGradle by lazy { "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt:detekt-formatting:1.20.0-RC1" }
}