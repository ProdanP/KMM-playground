plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js(IR) {
        useCommonJs()
        browser {
            webpackTask {
                output.libraryTarget = "commonjs2"
            }
        }
        binaries.executable()
    }

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
                implementation("co.touchlab:kermit:1.0.0")
                implementation("io.ktor:ktor-client-core:2.0.0-beta-1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
                implementation("io.ktor:ktor-client-logging:2.0.0-beta-1")
                implementation("io.ktor:ktor-client-serialization:2.0.0-beta-1")
                implementation("io.ktor:ktor-client-json:2.0.0-beta-1")
                implementation("io.ktor:ktor-client-content-negotiation:2.0.0-beta-1")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0-beta-1")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:2.0.0-beta-1")
            }
        }
        val iosX64Main by getting 
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:2.0.0-beta-1")
            }
        }
        val iosMain by creating {
            dependencies {
                implementation("io.ktor:ktor-client-ios:2.0.0-beta-1")
            }
        }
        val nativeMain by creating

        /* Main hierarchy */
        androidMain.dependsOn(commonMain)
        iosMain.dependsOn(nativeMain)
        iosX64Main.dependsOn(iosMain)
        iosArm64Main.dependsOn(iosMain)
        iosSimulatorArm64Main.dependsOn(iosMain)
        jsMain.dependsOn(commonMain)
        nativeMain.dependsOn(commonMain)

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidTest by getting
        val iosX64Test by getting 
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val jsTest by getting
        val iosTest by creating
        val nativeTest by creating

        /* Test hierarchy */
        androidTest.dependsOn(commonTest)
        iosTest.dependsOn(nativeTest)
        iosX64Test.dependsOn(iosTest)
        iosArm64Test.dependsOn(iosTest)
        iosSimulatorArm64Test.dependsOn(iosTest)
        jsTest.dependsOn(commonTest)
        nativeTest.dependsOn(commonTest)
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}
