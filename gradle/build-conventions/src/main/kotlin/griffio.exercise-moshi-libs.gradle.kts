plugins {
    kotlin("jvm")
}

// a plugin for moshi support that modules can use if they want to
dependencies {
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
}

