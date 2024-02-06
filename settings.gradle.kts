// download jdk toolchain automatically from https://foojay.io/ 
//plugins {
//    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
//}
// org.gradle.java.installations.auto-download=false is set in gradle.properties
rootProject.name = "sample"
includeBuild(".build-conventions") // composite build
include("exercises:some_training_module:exercise_1", "exercises:some_training_module:exercise_2", "exercises:some_training_module:exercise_3", "exercises:some_training_module:exercise_4") // usual sub projects
include("exercises:another_training_module:exercise_1", "exercises:another_training_module:exercise_2", "exercises:another_training_module:exercise_3") // usual sub projects
