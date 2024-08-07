import AppConfig.NAMESPACE
import org.gradle.api.Project

fun Project.getNameSpace() = NAMESPACE + "." + project.name.replace('-','.')