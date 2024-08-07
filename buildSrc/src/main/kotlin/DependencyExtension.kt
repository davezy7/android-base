import CoreDependencies.coreKtx
import CoreDependencies.desugarJdkLibs
import CoreDependencies.javapoet
import CoreDependencies.timber
import FeatureDependencies.activityCompose
import FeatureDependencies.composeBom
import FeatureDependencies.lifecycleRuntimeCompose
import FeatureDependencies.lifecycleRuntimeKtx
import FeatureDependencies.material
import FeatureDependencies.ui
import FeatureDependencies.uiGraphics
import FeatureDependencies.uiTooling
import FeatureDependencies.uiToolingPreview
import HiltDependencies.hiltAndroid
import HiltDependencies.hiltCompiler
import HiltDependencies.hiltNavigation
import RemoteDataDependencies.chucker
import RemoteDataDependencies.moshi
import RemoteDataDependencies.moshiCodegen
import RemoteDataDependencies.okHttp
import RemoteDataDependencies.okHttpBom
import RemoteDataDependencies.okHttpLoggingInterceptor
import RemoteDataDependencies.retrofit2
import RemoteDataDependencies.retrofitMoshiConverter
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

private const val implementation = "implementation"
private const val debugImplementation = "debugImplementation"
private const val ksp = "ksp"

private fun DependencyHandler.implement(dependency: Any) = add(implementation, dependency)
private fun DependencyHandler.ksp(dependency: Any) = add(ksp, dependency)

fun DependencyHandlerScope.implementCoreDependencies() {
    dependencies.add("coreLibraryDesugaring", desugarJdkLibs)
    dependencies.add(debugImplementation, timber)

    implement(coreKtx)
    implement(hiltAndroid)
    implement(hiltNavigation)
    implement(javapoet)
    ksp(hiltCompiler)
}

fun DependencyHandlerScope.implementFeatureDependencies() {
    implementCoreDependencies()
    implement(lifecycleRuntimeKtx)
    implement(lifecycleRuntimeCompose)
    implement(activityCompose)
    implement(platform(composeBom))
    implement(material)
    implement(ui)
    implement(uiGraphics)
    implement(uiTooling)
    implement(uiToolingPreview)
    implement(lifecycleRuntimeKtx)
    implement(lifecycleRuntimeKtx)
}

fun DependencyHandlerScope.implementRemoteDataDependencies() {
    implementCoreDependencies()
    implement(chucker)
    implement(platform(okHttpBom))
    implement(okHttp)
    implement(okHttpLoggingInterceptor)
    implement(moshi)
    ksp(moshiCodegen)
    implement(retrofitMoshiConverter)
    implement(retrofit2)
}

fun DependencyHandlerScope.implementModule(moduleName: String) =
    dependencies.add(implementation, project(moduleName))



