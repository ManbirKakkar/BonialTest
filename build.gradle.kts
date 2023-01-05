// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Kotlin.serialization)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

    configurations {
        all {
            exclude(group = "androidx.lifecycle", module = "lifecycle-viewmodel-ktx")
        }
    }

}


tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}