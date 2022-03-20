plugins {
    id(BuildPlugins.androidApp)
    id(BuildPlugins.kotlin)
    id(BuildPlugins.kapt)
    id(BuildPlugins.hilt)
    id(BuildPlugins.secrets)
    id(BuildPlugins.detekt)
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
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.Compose.ui)
    implementation(Deps.Kotlin.coroutines)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.AndroidX.lifecycleRuntime)
    implementation(Deps.AndroidX.activityCompose)
    implementation(Deps.AndroidX.navigationCompose)
    implementation(Deps.Hilt.android)
    implementation(Deps.Hilt.navigationCompose)
    kapt(Deps.Hilt.compiler)
    implementation(Deps.Coil.compose)
    implementation(Deps.Lottie.compose)
    implementation(Deps.AndroidX.splashscreen)

    // For instrumentation tests
    androidTestImplementation(Deps.Hilt.androidTesting)
    kaptAndroidTest(Deps.Hilt.compiler)
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.gsonConverter)
    implementation(Deps.Retrofit.loggingInterceptor)
    // For local unit tests
    testImplementation(Deps.Hilt.androidTesting)
    kaptTest(Deps.Hilt.compiler)


    implementation(Deps.Room.runtime)
    implementation(Deps.Room.ktx)
    kapt(Deps.Room.compiler)

    // optional - Test helpers
    testImplementation(Deps.Room.testing)
    // optional - Paging 3 Integration
    implementation(Deps.Paging.paging)
    implementation(Deps.Paging.runtime)
    implementation(Deps.Paging.compose)

    testImplementation(Deps.junit)
    testImplementation(Deps.truth)
    testImplementation(Deps.mockk)
    androidTestImplementation(Deps.AndroidX.Test.junit)
    androidTestImplementation(Deps.AndroidX.Test.espresso)
    implementation(Deps.Accompanist.insets)
    androidTestImplementation(Deps.Compose.uiTestJunit)
    debugImplementation(Deps.Compose.uiTooling)

    "mockImplementation"(Deps.Retrofit.mockWebserver)
    debugImplementation(Deps.leakcanary)
}