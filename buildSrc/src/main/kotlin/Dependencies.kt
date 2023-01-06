
object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.0"

    object Kotlin {
        private const val version = "1.5.20"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"

        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0"

        const val coreKtx ="androidx.core:core-ktx:1.2.0"
        object Coroutines {
            private const val version = "1.4.2"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Google {

        object Di {
            private const val version = "2.37"

            const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
            const val hilt = "com.google.dagger:hilt-android:$version"
            const val hiltKapt = "com.google.dagger:hilt-android-compiler:$version"
        }
    }

    object UserInterface{
        const val scaledPixel ="com.intuit.sdp:sdp-android:1.1.0"
        const val cardView = "androidx.cardview:cardview:1.0.0"
    }

    object AndroidX {

        private const val version = "1.3.1"
        const val appcompat = "androidx.appcompat:appcompat:$version"
        const val constrainLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"

    }

    object Lifecycle{
        const val common = "androidx.lifecycle:lifecycle-common:2.2.0"
        const val runtime = "androidx.lifecycle:lifecycle-runtime:2.2.0"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:2.1.0"
    }

    object ImageProcessor{
        const val glide = "com.github.bumptech.glide:glide:4.9.0"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.6.0"
        const val gson = "com.google.code.gson:gson:2.8.5"
        const val gsonConvertor = "com.squareup.retrofit2:converter-gson:2.5.0"
        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:3.12.0"
    }

    object Test {
        private const val coreVersion = "1.5.0"
        private const val extJUnitVersion = "1.1.5"
        private const val runnerVersion = "1.5.2"
        private const val espressoVersion = "3.5.1"

        const val core = "androidx.test:core:$coreVersion"
        const val junit = "androidx.test.ext:junit:$extJUnitVersion"
        const val junitKtx = "androidx.test.ext:junit-ktx:1.1.0"
        const val runner = "androidx.test:runner:$runnerVersion"

        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val espressoCoreContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"

        const val mock = "io.mockk:mockk-android:1.9.3"

    }


}
