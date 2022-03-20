plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(path = ":domain"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("androidx.paging:paging-common:${Versions.paging}")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:${Versions.truth}")
    testImplementation("io.mockk:mockk:${Versions.mockk}")

}