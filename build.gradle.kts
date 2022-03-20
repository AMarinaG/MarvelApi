buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
        classpath("io.gitlab.arturbosch.detekt:detekt-formatting:1.20.0-RC1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
    id("io.gitlab.arturbosch.detekt") version "1.20.0-RC1" apply false
}

tasks.create("clean", Delete::class) {
    delete(rootProject.buildDir)
}