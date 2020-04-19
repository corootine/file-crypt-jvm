package com.corootine.filecrypt.crypto

import com.corootine.filecrypt.cmd.CryptoMode
import javax.crypto.Cipher

interface Crypto {

    fun init(mode: CryptoMode): Cipher

    fun update(cipher: Cipher, data: ByteArray): ByteArray

    fun finish(cipher: Cipher, data: ByteArray): ByteArray
}