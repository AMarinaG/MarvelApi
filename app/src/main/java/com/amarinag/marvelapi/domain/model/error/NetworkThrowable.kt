package com.amarinag.marvelapi.domain.model.error

import com.amarinag.marvelapi.R

class NetworkThrowable(exception: Exception? = null) :
    AmgThrowable(R.string.error_network_error, exception)