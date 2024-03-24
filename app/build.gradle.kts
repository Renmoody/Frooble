plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.frooble"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.frooble"
        minSdk = 16
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // https://mvnrepository.com/artifact/javax.activation/activation
    implementation("javax.activation:activation:1.1.1")
    // https://mvnrepository.com/artifact/javax.mail/mail
    //implementation("javax.mail:mail:1.4.7")
    // https://mvnrepository.com/artifact/javax.mail/mail
    //implementation("javax.mail:mail:1.4")
    // https://mvnrepository.com/artifact/javax.mail/javax.mail-api
    implementation("javax.mail:javax.mail-api:1.6.2")
    // https://mvnrepository.com/artifact/org.springframework/spring-context
    //implementation("org.springframework:spring-context:6.1.5")


}