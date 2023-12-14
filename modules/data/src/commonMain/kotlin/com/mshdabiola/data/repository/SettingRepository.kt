package com.mshdabiola.data.repository

import com.mshdabiola.model.DummySetting
import com.mshdabiola.setting.MultiplatformSettings

internal class SettingRepository(private val settings: MultiplatformSettings) : ISettingRepository {
    override suspend fun setDummy(dummy: DummySetting) {
        settings.setDummy(dummy)
    }

}