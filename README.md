## Exercises Build Convention

Exercise projects share the same build config, this is located in `gradle\build-conventions` sub-project.

This is to be opened in Intellij at the root of the repo - with each exercise runnable in self-contained build.
There is no top level build file - instead each exercise project has its own build file, there is composite build for conventions.
based on `https://docs.gradle.org/current/samples/sample_sharing_convention_plugins_with_build_logic.html`

The `gradle/build-conventions` (moved to gradle folder to keep top-level tidy) wraps the build configuration as a plugin `griffio.exercise-conventions` to be used in the exercise projects,
this `includeBuild` works effectively the same as using a top-level gradle `buildSrc` that can be named and located elsewhere.

New exercise directories, where adding the build.gradle.kts, can be included in `settings.gradle.kts` for the build to run.

Requires JAVA_HOME for JDK 17 installed - gradle.properties and settings.gradle.kts disables plugin `org.gradle.toolchains.foojay-resolver-convention` to automatically download jdks.

### Conventions 

Flatten `src/main/kotlin`, `src/main/java`  to `src`, allow mix of Kotlin and Java sources, set the Main class, use a JDK 17 toolchain.

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
    jvmToolchain(17) // could be any other JDK 
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

Create an alias to the exercise project `run` task relative to the repo

```
alias run_ex='$(git rev-parse --show-toplevel)/gradlew run --continuous'
```
