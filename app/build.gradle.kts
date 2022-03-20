plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.amarinag.marvelapi"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        reportDir = "$rootDir/test-reports"
        resultsDir = "$rootDir/test-results"
//        unitTests.setReturnDefaultValues(true)
    }
    flavorDimensions += "environment"
    productFlavors {
        create("mock") {
            dimension = "environment"
            applicationIdSuffix = ".mock"
        }
        create("pro") {
            dimension = "environment"
        }
    }
}
secrets {
    propertiesFileName = "secrets.properties"

}
detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    config = files("$rootDir/config/detekt.yml")
    // point to your custom config defining rules to run, overwriting default behavior
    baseline = file("$rootDir/config/baseline.xml")
    // a way of suppressing issues before introducing detekt
}
dependencies {
    implementation(project(path = ":data"))
    implementation(project(path = ":domain"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:${Versions.navigation}")
    implementation("com.google.dagger:hilt-android:${Versions.hilt}")
    implementation("androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hilt}")
    implementation("io.coil-kt:coil-compose:${Versions.coil}")
    implementation("com.airbnb.android:lottie-compose:${Versions.lottie}")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:${Versions.hilt}")
    kaptAndroidTest("com.google.dagger:hilt-compiler:${Versions.hilt}")
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}")
    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:${Versions.hilt}")
    kaptTest("com.google.dagger:hilt-compiler:${Versions.hilt}")


    implementation("androidx.room:room-runtime:${Versions.room}")
    implementation("androidx.room:room-ktx:${Versions.room}")
    kapt("androidx.room:room-compiler:${Versions.room}")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:${Versions.room}")
    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:${Versions.room}")
    implementation("androidx.paging:paging-runtime:${Versions.paging}")
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:${Versions.truth}")
    testImplementation("io.mockk:mockk:${Versions.mockk}")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.google.accompanist:accompanist-insets:${Versions.accompanist}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose}")

    "mockImplementation"("com.squareup.okhttp3:mockwebserver:${Versions.mockWebservice}")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}")
}