@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.firebase.perf) apply false
    alias(libs.plugins.gms) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.compose.gradlePlugin)
//    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.manes)
    alias(libs.plugins.little)
//    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidx.baselineprofile) apply false

}
buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        //classpath(libs.moko.resources.plugin)
    }
}


//./gradlew versionCatalogUpdate
versionCatalogUpdate {
    // sort the catalog by key (default is true)
    sortByKey.set(true)
    // Referenced that are pinned are not automatically updated.
    // They are also not automatically kept however (use keep for that).
    keep {

        // keep versions without any library or plugin reference
        keepUnusedVersions.set(true)
        // keep all libraries that aren't used in the project
        keepUnusedLibraries.set(true)
        // keep all plugins that aren't used in the project
        keepUnusedPlugins.set(true)
    }
}


//tasks.create("add_spot"){
//    val proj=project.rootDir
//
//  //  doFirst{
//        print("add spotless to git")
//        val gitHooksDirectory = File("$proj/.git/hooks/")
//        if (!gitHooksDirectory.exists()) gitHooksDirectory.mkdirs()
//        File("$proj/.git/hooks", "pre-commit").writeText(
//            """
//    #!/bin/bash
//    echo "Running spotless check"
//    ./gradlew spotlessApply --init-script gradle/init.gradle.kts
//"""
//        )
//
//        exec {
//            commandLine("chmod","+x", ".git/hooks/pre-commit")
//        }
//
//  //  }
//
//}
//.gradlew add_spot

//./gradlew assembleDebug -PenableComposeCompilerReports=true
// ./gradlew assembleDebug -PenableComposeCompilerMetrics=true