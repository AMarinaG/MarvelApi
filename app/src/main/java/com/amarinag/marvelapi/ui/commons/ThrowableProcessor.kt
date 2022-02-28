package com.amarinag.marvelapi.ui.commons

import android.content.Context
import android.content.res.Resources
import com.amarinag.marvelapi.domain.model.error.AmgThrowable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThrowableProcessor @Inject constructor(@ApplicationContext context: Context) {
    private val resources: Resources = context.resources
    fun proccess(throwable: Throwable): String {
        return when (throwable) {
            is AmgThrowable -> resources.getString(throwable.stringId)
            else -> throwable.localizedMessage
        }
    }
}