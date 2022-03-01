package com.amarinag.marvelapi.utils

import android.content.Context
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppResources @Inject constructor(@ApplicationContext private val context: Context) {
    fun getString(@StringRes stringResourceId: Int): String = context.getString(stringResourceId)
    fun getRawFile(@RawRes fileResourceId: Int) =
        context.resources.openRawResource(fileResourceId).bufferedReader().use { it.readText() }
}