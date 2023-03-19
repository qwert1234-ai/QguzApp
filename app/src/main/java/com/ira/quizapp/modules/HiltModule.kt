package com.ira.quizapp.modules

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent:: class)
abstract class HiltModule {
}