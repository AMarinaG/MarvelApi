object BuildPlugins {
    val androidApp by lazy { "com.android.application" }
    val androidLib by lazy { "com.android.library" }
    val javaLib by lazy { "java-library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
    val kotlinJvm by lazy { "org.jetbrains.kotlin.jvm" }
    val kapt by lazy { "kotlin-kapt" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt" }
    val hilt by lazy { "dagger.hilt.android.plugin" }
    val secrets by lazy { "com.google.android.libraries.mapsplatform.secrets-gradle-plugin" }
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
        val coreKtx by lazy { "androidx.core:core-ktx:1.7.0" }
        val splashscreen by lazy { "androidx.core:core-splashscreen:${Versions.coreSplashscreen}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
        val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
        val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigation}" }

        object Test {
            val junit by lazy { "androidx.test.ext:junit:1.1.3" }
            val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        }
    }

    object Compose {
        val ui by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
        val material by lazy { "androidx.compose.material:material:${Versions.compose}" }
        val uiTestJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    }

    object Accompanist {
        val insets by lazy { "com.google.accompanist:accompanist-insets:${Versions.accompanist}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val androidTesting by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
        val navigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
    }

    object Coil {
        val compose by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
    }

    object Lottie {
        val compose by lazy { "com.airbnb.android:lottie-compose:${Versions.lottie}" }
    }

    object Retrofit {
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
        val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
        val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }
        val mockWebserver by lazy { "com.squareup.okhttp3:mockwebserver:${Versions.mockWebservice}" }
    }

    object Room {
        val runtime by lazy { "androidx.room:room-runtime:${Versions.room}" }
        val ktx by lazy { "androidx.room:room-ktx:${Versions.room}" }
        val compiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
        val testing by lazy { "androidx.room:room-testing:${Versions.room}" }
    }

    object Paging {
        val paging by lazy { "androidx.room:room-paging:${Versions.room}" }
        val common by lazy { "androidx.paging:paging-common:${Versions.paging}" }
        val runtime by lazy { "androidx.paging:paging-runtime:${Versions.paging}" }
        val compose by lazy { "androidx.paging:paging-compose:1.0.0-alpha14" }

    }

    val junit by lazy { "junit:junit:4.13.2" }
    val truth by lazy { "com.google.truth:truth:${Versions.truth}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val leakcanary by lazy { "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}" }
}