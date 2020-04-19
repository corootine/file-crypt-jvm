package com.corootine.filecrypt.cek

interface CekProvider {

    fun provide(): Cek
}