import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.apolloGraphQl)
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.rocketreserver"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(libs.apolloRuntime)
    implementation(libs.appcompat)
    implementation(libs.coil)
    implementation(libs.constraintLayout)
    implementation(libs.coreKtx)
    implementation(libs.hilt)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.material)
    implementation(libs.navigationFragmentKtx)
    implementation(libs.navigationUiKtx)
    implementation(libs.pagingRuntimeKtx)
    implementation(libs.recyclerView)
    implementation(libs.securityCrypto)

    kapt(libs.hiltCompiler)

    androidTestImplementation(libs.bundles.androidTest)

    testImplementation(libs.bundles.test)
}

apollo {
    packageName.set("com.example.rocketreserver")
}
