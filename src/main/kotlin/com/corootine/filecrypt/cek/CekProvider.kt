package com.corootine.filecrypt.cek

interface CekProvider {

    fun provide(secret: CharArray): Cek
}