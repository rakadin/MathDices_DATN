plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.mathdices"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mathdices"
        minSdk = 24
        targetSdk = 33
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.17")
    implementation ("com.android.support:appcompat-v7:28.0.0")
    implementation ("com.android.support.constraint:constraint-layout:2.0.4")
    implementation ("com.android.support:design:28.0.0")
    implementation ("android.arch.navigation:navigation-fragment:1.0.0")
    implementation ("android.arch.navigation:navigation-ui:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}