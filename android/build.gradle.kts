allprojects {
    repositories {
        google()
        mavenCentral()
    }
    buildscript {
        dependencies {
            classpath("com.android.tools.build:gradle:8.2.2")
            classpath("com.google.gms:google-services:4.4.1")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
        }
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

// Root-level (Project-level) build.gradle.kts
plugins {
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.application") version "8.7.0" apply false
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false
}


