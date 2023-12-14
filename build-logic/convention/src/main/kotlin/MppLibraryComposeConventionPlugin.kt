/*
 * Copyright 2022 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.android.build.gradle.LibraryExtension
import com.mshdabiola.app.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class MppLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("kotlin-multiplatform")
//            pluginManager.apply("mshdabiola.mpp.library")
            pluginManager.apply("org.jetbrains.compose")
//
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            val composeExtension = extensions.getByType<ComposeExtension>()

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
            extensions.configure<KotlinMultiplatformExtension> {
                with(sourceSets) {

                    getByName("commonMain") {
                        this.dependencies {
                            implementation(composeExtension.dependencies.runtime)
                            implementation(composeExtension.dependencies.foundation)
                            implementation(composeExtension.dependencies.material3)
                            implementation(composeExtension.dependencies.materialIconsExtended) // TODO not working on iOS for now
                            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                            implementation(composeExtension.dependencies.components.resources)
                            implementation(composeExtension.dependencies.preview)
                            implementation(
                                libs.findLibrary("androidx.compose.material3.windowSizeClass").get()
                            )
//                            implementation("org.jetbrains.compose.ui:ui-tooling-preview:1.5.10-beta02")
//                            implementation("org.jetbrains.compose.runtime:runtime:1.5.10-beta02")
//                            implementation("org.jetbrains.compose.ui:ui:1.5.0-dev1147")
//                            implementation("org.jetbrains.compose.foundation:foundation:1.5.10-beta02")
//                            implementation("org.jetbrains.compose.material:material-icons-extended:1.5.10-beta02")
//                            implementation("org.jetbrains.compose.material3:material3:1.5.10-beta02")


                        }

                    }
//                    getByName("commonTest") {
//                        this.dependencies {
//
//                        }
//
//                    }
//                    getByName("androidMain") {
//                        this.dependencies {
//
//
//                        }
//
//                    }
//                    getByName("androidInstrumentedTest") {
//                        this.dependencies {
//
//                        }
//
//                    }
//                    getByName("desktopMain") {
//                        this.dependencies {
//
//                        }
//
//                    }
//                    getByName("desktopTest") {
//                        this.dependencies {
//                            // implementation(libs.findLibrary("koin.core").get())
//
//                        }
//
//                    }
                }

            }


        }
    }

}