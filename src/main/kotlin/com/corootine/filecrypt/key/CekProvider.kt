package com.corootine.filecrypt.key

import javax.crypto.SecretKey

interface CekProvider {

    fun provide(secret: CharArray): SecretKey
}