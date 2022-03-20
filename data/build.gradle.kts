plugins {
    id(BuildPlugins.javaLib)
    id(BuildPlugins.kotlinJvm)
    id(BuildPlugins.kapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(path = ":domain"))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.Kotlin.coroutines)
    implementation(Deps.Paging.common)
    testImplementation(Deps.junit)
    testImplementation(Deps.truth)
    testImplementation(Deps.mockk)

}