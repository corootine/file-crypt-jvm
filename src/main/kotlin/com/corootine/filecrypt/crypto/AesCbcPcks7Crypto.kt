package com.corootine.filecrypt.crypto

import com.corootine.filecrypt.cek.CekProvider
import com.corootine.filecrypt.cmd.CryptoMode
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

class AesCbcPcks7Crypto(private val cekProvider: CekProvider) : Crypto {

    override fun init(mode: CryptoMode): Cipher {
        val cek = cekProvider.provide()
        val iv = generateIv(cek.keyLength)

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(getOperationMode(mode), cek.key, IvParameterSpec(iv))
        return cipher
    }

    override fun update(cipher: Cipher, data: ByteArray): ByteArray = cipher.update(data)

    override fun finish(cipher: Cipher, data: ByteArray): ByteArray = cipher.doFinal(data)

    private fun getOperationMode(mode: CryptoMode): Int =
        when (mode) {
            CryptoMode.ENCRYPT -> Cipher.ENCRYPT_MODE
            CryptoMode.DECRYPT -> Cipher.DECRYPT_MODE
        }

    private fun generateIv(keyLength: Int): ByteArray {
        val secureRandom = SecureRandom()
        val iv = ByteArray(keyLength / 8)
        secureRandom.nextBytes(iv)
        return iv
    }
}