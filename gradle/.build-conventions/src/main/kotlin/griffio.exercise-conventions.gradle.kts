plugins {
    application
    kotlin("jvm") // https://docs.gradle.org/current/userguide/compatibility.html#kotlin
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
   // if setting.gradle.kts uses plugin org.gradle.toolchains.foojay-resolver-convention is enabled, this will be download jdk 17 from foojay.io
}

