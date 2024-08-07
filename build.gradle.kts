// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(PluginDependencies.androidApplication) apply false
    id(PluginDependencies.androidLibrary) apply false
    id(PluginDependencies.kotlinAndroid) apply false
    id(PluginDependencies.composeCompiler) apply false
    id(PluginDependencies.ksp) apply false
    id(PluginDependencies.hiltAndroid) version DependenciesVersionCatalog.hiltVersion apply false
}