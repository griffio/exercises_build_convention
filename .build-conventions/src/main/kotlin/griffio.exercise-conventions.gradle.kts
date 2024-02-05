plugins {
    application
    kotlin("jvm")
}

group = "exercises"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

sourceSets.main { // override the nested layout
    kotlin.srcDirs("src")
    java.srcDirs("src")
}

dependencies {
}

application {
    mainClass = "MainKt"
}

kotlin {
    jvmToolchain(17)
}

