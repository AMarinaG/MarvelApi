object BuildPlugins {
    val androidApp by lazy { "com.android.application" }
    val androidLib by lazy { "com.android.library" }
    val javaLib by lazy { "java-library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
    val kotlinJvm by lazy { "org.jetbrains.kotlin.jvm" }
    val kapt by lazy { "kotlin-kapt" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt" }
}

object Buildscript {
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val secretGradle by lazy { "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt:detekt-formatting:1.20.0-RC1" }
}

object Deps {
    object Kotlin {
        val stdlib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
        val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0" }
    }

    object AndroidX {
        val pagingCommon by lazy { "androidx.paging:paging-common:${Versions.paging}" }
    }



    val junit by lazy { "junit:junit:4.13.2" }
    val truth by lazy { "com.google.truth:truth:${Versions.truth}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
}