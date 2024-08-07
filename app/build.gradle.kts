import AppConfig.APPLICATION_ID
import AppConfig.BUILD_TOOLS_VERSION
import AppConfig.COMPILE_SDK
import AppConfig.MIN_SDK
import AppConfig.TARGET_SDK
import AppConfig.TEST_INSTRUMENTATION_RUNNER
import AppConfig.VERSION_CODE
import Modules.CORE_NAVIGATION
import Modules.CORE_NETWORK
import Modules.CORE_SYSTEM
import Modules.CORE_UI
import Modules.DATA_EXAMPLE_ONE
import Modules.FEATURE_ONE
import Modules.FEATURE_TWO
import org.gradle.api.JavaVersion.VERSION_17

plugins {
    id(PluginDependencies.androidApplication)
    id(PluginDependencies.kotlinAndroid)
    id(PluginDependencies.composeCompiler)
    id(PluginDependencies.ksp)
    id(PluginDependencies.hiltAndroid)
}

android {
    namespace = getNameSpace()
    compileSdk = COMPILE_SDK
    buildToolsVersion = BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = APPLICATION_ID
        minSdk = MIN_SDK
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        targetSdk = TARGET_SDK
        testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
        versionCode = VERSION_CODE
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            isShrinkResources = false
            isJniDebuggable = false
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
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

    packaging {
        jniLibs {
            useLegacyPackaging = true
            pickFirsts.add("**/libc++_shared.so")
        }
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

    testOptions.unitTests.isReturnDefaultValues = true
}

dependencies {
    implementModule(CORE_NAVIGATION)
    implementModule(CORE_NETWORK)
    implementModule(CORE_SYSTEM)
    implementModule(CORE_UI)
    implementModule(DATA_EXAMPLE_ONE)
    implementModule(FEATURE_ONE)
    implementModule(FEATURE_TWO)
    implementFeatureDependencies()
    implementRemoteDataDependencies()
}