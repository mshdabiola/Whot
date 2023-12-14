package com.mshabiola.database.di

import com.mshabiola.database.util.Constant
import com.mshdabiola.database.TempDatabase
import com.mshdabiola.model.generalPath
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual val databaseModule: Module
    get() = module {
        single {
            val dir = File(generalPath)
            if (dir.exists().not()) {
                dir.mkdirs()
            }
            val dbPath = File(generalPath, Constant.databaseName)
            println(" path ${dbPath.path}")

            val driver = withDatabase(dbPath.path)
//
//            val driver = JdbcSqliteDriver(url = "jdbc:sqlite:${dbPath.absolutePath}")
//                .also {
//                    TempDatabase.Schema.create(it)
//                    println("file  ${dbPath.path}")
//                }
//            println("version ${TempDatabase.Schema.version}")

            TempDatabase(driver)
        }

        includes(daoModules)

    }

//private var version: Int
//    get() {
//        val sqlCursor = driver.executeQuery(null, "PRAGMA user_version;", 0, null)
//        return sqlCursor.getLong(0)!!.toInt()
//    }
//    private set(version) {
//        driver.execute(null, String.format("PRAGMA user_version = %d;", version), 0, null)
//    }