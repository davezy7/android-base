import DependenciesVersionCatalog.activityComposeVersion
import DependenciesVersionCatalog.androidxTestExtJunitVersion
import DependenciesVersionCatalog.chuckerVersion
import DependenciesVersionCatalog.composeBomVersion
import DependenciesVersionCatalog.coreKtxVersion
import DependenciesVersionCatalog.desugarJdkLibsVersion
import DependenciesVersionCatalog.espressoCoreVersion
import DependenciesVersionCatalog.hiltNavigationVersion
import DependenciesVersionCatalog.hiltVersion
import DependenciesVersionCatalog.javapoetVersion
import DependenciesVersionCatalog.junitVersion
import DependenciesVersionCatalog.lifecycleRuntimeVersion
import DependenciesVersionCatalog.materialVersion
import DependenciesVersionCatalog.moshiVersion
import DependenciesVersionCatalog.okhttpVersion
import DependenciesVersionCatalog.retrofit2Version
import DependenciesVersionCatalog.timberVersion

object CoreDependencies {
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:$desugarJdkLibsVersion"
    const val timber = "com.jakewharton.timber:timber:$timberVersion"
    const val javapoet = "com.squareup:javapoet:$javapoetVersion"
}

object TestDependencies {
    const val junit = "junit:junit$junitVersion"
    const val androidxTestExtJunit = "androidx.test.ext:junit:$androidxTestExtJunitVersion"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
}

object HiltDependencies {
    const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
}

object FeatureDependencies {
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"
    const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleRuntimeVersion"
    const val material = "androidx.compose.material3:material3-android:$materialVersion"
    const val ui = "androidx.compose.ui:ui"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
}

object RemoteDataDependencies {
    const val chucker = "com.github.chuckerteam.chucker:library:$chuckerVersion"
    const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:$okhttpVersion"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofit2Version"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofit2Version"
}

object PluginDependencies {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val composeCompiler = "org.jetbrains.kotlin.plugin.compose"
    const val hiltAndroid = "com.google.dagger.hilt.android"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val ksp = "com.google.devtools.ksp"
}