plugins {
    id("mshdabiola.mpp.library")
    id("app.cash.sqldelight") version libs.versions.sqlDelight
}

sqldelight {

    databases {

        create("TempDatabase") {
            packageName.set("com.mshdabiola.database")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/com.mshdabiola.database/files"))
            //dialect("sqlite:3.38")
        }
    }

}

android {
    namespace = "com.mshdabiola.database"
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":modules:model"))

                // implementation(libs.koin.core)
                //   implementation(libs.kermit.log)
                implementation(libs.sqldelight.runtime)
                implementation(libs.sqldelight.coroutines)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        val androidMain by getting {
            dependencies {
                //implementation(libs.androidx.compose.ui)

                implementation(libs.sqldelight.android.driver)
            }
        }


        val desktopMain by getting {
            dependencies {
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        val desktopTest by getting

//        val jsMain by getting {
//            dependencies {
//
//            }
//        }
    }
}
