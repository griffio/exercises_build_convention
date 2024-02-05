** Exercises Build Convention

Exercise projects share the same build config, this is located in build-conventions sub-project.

There is no top level build file - instead each exercise project has its own build file, there is composite build for conventions.
based on `https://docs.gradle.org/current/samples/sample_sharing_convention_plugins_with_build_logic.html`

The `.build-conventions` wraps the build configuration as a plugin `griffio.exercise-conventions` to be used in the exercise projects,
this composite  works effectively the same as using a gradle `buildSrc`.

Conventions - flatten `src/main/kotlin` to `src`, mix Kotlin and Java sources, set the Main class.

```
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

```

Run all exercises

```
./gradlew run
```

or each module exercise project

```
./gradlew :some_training_module:exercise_1:run
```

