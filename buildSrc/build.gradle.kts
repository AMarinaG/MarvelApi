plugins {
    kotlin("jvm") version "1.6.10"
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:7.1.2")
    implementation(kotlin("stdlib"))
    gradleApi()
}