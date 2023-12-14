package com.mshdabiola.setting

import com.mshdabiola.model.DummySetting
import kotlinx.coroutines.flow.Flow

interface MultiplatformSettings {

    val name: Flow<String>
    val dummy: Flow<DummySetting>

    suspend fun setName(name: String)

    suspend fun setDummy(dummy: DummySetting)

}
