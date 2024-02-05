plugins {
    `kotlin-dsl`  // gradle uses a special internal version for compatibility reasons
}

repositories {
    gradlePluginPortal()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
}
