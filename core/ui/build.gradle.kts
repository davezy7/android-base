import Modules.CORE_SYSTEM

plugins {
    id("feature-plugin")
}

dependencies {
    implementModule(CORE_SYSTEM)
    implementFeatureDependencies()
}