package com.corootine.filecrypt.cek

import javax.crypto.SecretKey

interface CekProvider {

    fun provide(secret: CharArray): SecretKey
}