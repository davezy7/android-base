import Modules.CORE_NETWORK
import Modules.CORE_SYSTEM

plugins {
    id("common-plugin")
}

dependencies {
    implementModule(CORE_SYSTEM)
    implementModule(CORE_NETWORK)
    implementRemoteDataDependencies()
}