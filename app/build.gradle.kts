plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // Configuración del nombre de tu paquete
    namespace = "com.example.billeteramvc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.billeteramvc"
        minSdk = 26

        // Optimizado para que funcione perfecto en tu Motorola G30 (Android 12 / API 31)
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

    // Configuración de Java 17 para evitar errores de compilación modernos
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Librerías base de Android y Kotlin sin usar archivos 'libs.toml'
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")

    // Herramientas de pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
