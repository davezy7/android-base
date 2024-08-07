import AppConfig.BUILD_TOOLS_VERSION
import AppConfig.COMPILE_SDK
import AppConfig.DEFAULT_PROGUARD_FILE
import AppConfig.MIN_SDK
import AppConfig.PROGUARD_FILE
import AppConfig.TEST_INSTRUMENTATION_RUNNER
import gradle.kotlin.dsl.accessors._148a98e37ba40cbabdf8cfe10d738bc6.android
import gradle.kotlin.dsl.accessors._148a98e37ba40cbabdf8cfe10d738bc6.kotlinOptions
import org.gradle.api.JavaVersion.VERSION_17

plugins {
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

android {
    namespace = getNameSpace()
    compileSdk = COMPILE_SDK
    buildToolsVersion = BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = MIN_SDK
        multiDexEnabled = true
        testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(DEFAULT_PROGUARD_FILE), PROGUARD_FILE)
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = VERSION_17
        targetCompatibility = VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += "-Xcontext-receivers"
    }

    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

dependencies {
    implementFeatureDependencies()
}