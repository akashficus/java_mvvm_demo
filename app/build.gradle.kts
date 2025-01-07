plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.rf.javamvvmdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rf.javamvvmdemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lint {
        baseline = file("lint-baseline.xml")
    }



}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.dagger)
    annotationProcessor(libs.daggerCompiler)
    implementation(libs.retrofit)
    implementation(libs.gsonConverter)
    implementation(libs.loggingInterceptor)
    implementation(libs.roomRuntime)
    annotationProcessor(libs.roomCompiler)
    implementation(libs.glide)
    annotationProcessor(libs.glideCompiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}