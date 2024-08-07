import Modules.CORE_NAVIGATION
import Modules.CORE_SYSTEM
import Modules.CORE_UI
import Modules.DATA_EXAMPLE_ONE

plugins {
    id("feature-plugin")
}

dependencies {
    implementModule(DATA_EXAMPLE_ONE)
    implementModule(CORE_NAVIGATION)
    implementModule(CORE_SYSTEM)
    implementModule(CORE_UI)
    implementFeatureDependencies()
}