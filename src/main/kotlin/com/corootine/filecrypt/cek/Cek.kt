package com.corootine.filecrypt.cek

import javax.crypto.SecretKey

data class Cek(val keyLength: Int, val key: SecretKey)