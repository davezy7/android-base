import Modules.CORE_SYSTEM

plugins {
    id("common-plugin")
}

dependencies {
    implementModule(CORE_SYSTEM)
    implementRemoteDataDependencies()
}