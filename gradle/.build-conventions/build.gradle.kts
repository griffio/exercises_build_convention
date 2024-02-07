plugins {
    `kotlin-dsl`  // gradle uses embedded version for plugins backwards compatibility
}

repositories {
    gradlePluginPortal()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
  // https://docs.gradle.org/current/userguide/compatibility.html#kotlin
}
