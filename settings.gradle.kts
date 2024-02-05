rootProject.name = "sample"
includeBuild(".build-conventions") // composite build
include("some_training_module:exercise_1", "some_training_module:exercise_2", "some_training_module:exercise_3", "some_training_module:exercise_4") // usual sub projects
include("another_training_module:exercise_1", "another_training_module:exercise_2", "another_training_module:exercise_3") // usual sub projects
