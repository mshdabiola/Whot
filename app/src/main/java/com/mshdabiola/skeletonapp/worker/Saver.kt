package com.mshdabiola.skeletonapp.worker

import androidx.work.WorkManager


fun WorkManager.getWorkLiveData() =
    this
        .getWorkInfosForUniqueWorkLiveData("updater")





