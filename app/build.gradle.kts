plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("android")
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion(ConfigData.buildToolsVersion)

    defaultConfig {
        applicationId = "com.bonial.test"
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude("META-INF/notice.txt")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }
    namespace = "io.bonial.test"
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.constrainLayout)
    implementation(Libs.AndroidX.recyclerview)

    implementation(Libs.ImageProcessor.glide)

    implementation(Libs.Kotlin.Coroutines.android)
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.serializationJson)
    implementation(Libs.Kotlin.coreKtx)

    implementation(Libs.Lifecycle.common)
    implementation(Libs.Lifecycle.runtime)
    implementation(Libs.Lifecycle.lifecycle)
    implementation(Libs.Lifecycle.livedata)

    implementation(Libs.Network.gsonConvertor)
    implementation(Libs.Network.gson)
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.okHttpLogging)

    implementation(Libs.UserInterface.scaledPixel)
    implementation(Libs.UserInterface.cardView)
    testImplementation("junit:junit:4.12")

    androidTestImplementation(Libs.Test.core)
    androidTestImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junitKtx)
    androidTestImplementation(Libs.Test.runner)
    androidTestImplementation(Libs.Test.espressoCore)
    androidTestImplementation(Libs.Test.espressoCoreContrib)
    androidTestImplementation(Libs.Test.mock)
}