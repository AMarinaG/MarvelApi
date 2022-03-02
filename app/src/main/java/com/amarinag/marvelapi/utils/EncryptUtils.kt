package com.amarinag.marvelapi.utils

import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

private const val FirstByte = 0xFF
private fun String.toMd5(): String {
    val md5 = "MD5"
    try {
        val digest = MessageDigest.getInstance(md5)
        digest.update(this.toByteArray())
        val messageDigest = digest.digest()

        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(FirstByte and aMessageDigest.toInt())
            while (h.length < 2) {
                h = "0$h"
            }
            hexString.append(h)
        }
        return hexString.toString()
    } catch (nsae: NoSuchAlgorithmException) {
        Log.e("Utils", "error: $nsae", nsae)
    }
    return ""
}

fun generateHash(time: Long, privateKey: String, publicKey: String): String =
    "$time$privateKey$publicKey".toMd5()
