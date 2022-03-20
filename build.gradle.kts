buildscript {
    dependencies {
        classpath(Buildscript.hilt)
        classpath(Buildscript.secretGradle)
        classpath(Buildscript.detekt)
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.androidApp) version Versions.agp apply false
    id(BuildPlugins.androidLib) version Versions.agp apply false
    id(BuildPlugins.kotlin) version Versions.kotlin apply false
    id(BuildPlugins.kotlinJvm) version Versions.kotlin apply false
    id(BuildPlugins.detekt) version Versions.detekt apply false
}

tasks.create("clean", Delete::class) {
    delete(rootProject.buildDir)
}