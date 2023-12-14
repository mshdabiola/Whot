/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    `kotlin-dsl`
}

group = "com.mshdabiola.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradle)
    compileOnly(libs.firebase.performance.gradle)
    compileOnly(libs.kotlin.gradlePlugin)
    // compileOnly(libs.ksp.gradlePlugin)

    compileOnly(libs.compose.gradlePlugin)
    //compileOnly(libs.compose.multiplatform.plugin)
}

gradlePlugin {
    plugins {

        register("androidApplicationCompose") {
            id = "mshdabiola.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationFlavor") {
            id = "mshdabiola.android.application.flavor"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidApplicationFirebase") {
            id = "mshdabiola.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidApplication") {
            id = "mshdabiola.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "mshdabiola.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "mshdabiola.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "mshdabiola.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidTest") {
            id = "mshdabiola.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }

        register("desktop") {
            id = "mshdabiola.mpp.desktop"
            implementationClass = "Desktop"
        }
        register("mppLibrary") {
            id = "mshdabiola.mpp.library"
            implementationClass = "MppLibraryConventionPlugin"
        }
        register("mppLibraryCompose") {
            id = "mshdabiola.mpp.library.compose"
            implementationClass = "MppLibraryComposeConventionPlugin"
        }
        register("mppFeature") {
            id = "mshdabiola.mpp.feature"
            implementationClass = "MppFeatureConventionPlugin"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}