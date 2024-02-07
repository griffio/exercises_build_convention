## Exercises Build Convention

Exercise projects share the same build config, this is located in build-conventions sub-project.

There is no top level build file - instead each exercise project has its own build file, there is composite build for conventions.
based on `https://docs.gradle.org/current/samples/sample_sharing_convention_plugins_with_build_logic.html`

The `.build-conventions` wraps the build configuration as a plugin `griffio.exercise-conventions` to be used in the exercise projects,
this composite  works effectively the same as using a gradle `buildSrc`.

Requires JDK 17 installed as foojay plugin is disabled

### Conventions - flatten `src/main/kotlin` to `src`, mix Kotlin and Java sources, set the Main class, JDK 17 toolchain.

settings.gradle.kts disables plugin `org.gradle.toolchains.foojay-resolver-convention` to automatically download jdks

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

Run all exercises from the top-level directory

```
./gradlew run
```

or each exercise project individually

```
./gradlew :exercises:some_training_module:exercise_1:run
```

same path abbreviated

```
./gradlew e:s:ex_1:run
```

Execute Gradle wrapper relatively from within exercise project

```
cd exercises_build_convention/exercises/some_training_module/exercise_2

../../../gradlew run
```

Run a task continuously, this will wait for changes to the source code and re-run saving startup time
```
./gradlew e:s:exercise_1:run --continuous
```
