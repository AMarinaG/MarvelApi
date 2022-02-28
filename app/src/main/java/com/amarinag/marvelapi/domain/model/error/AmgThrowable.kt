package com.amarinag.marvelapi.domain.model.error

import androidx.annotation.StringRes
import com.amarinag.marvelapi.R

open class AmgThrowable(
    @StringRes
    val stringId: Int = R.string.error_generic_error,
    ex: Exception? = null
) : Throwable("$stringId", ex)