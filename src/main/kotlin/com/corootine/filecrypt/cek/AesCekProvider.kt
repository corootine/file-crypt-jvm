package com.corootine.filecrypt.cek

import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

class AesCekProvider(secret: CharArray) : CekProvider {

    private var cek: Cek

    init {
        val factory = SecretKeyFactory.getInstance(ALGORITHM)
        val keySpec = PBEKeySpec(secret, SALT, ITERATION_COUNT, KEY_LENGTH)
        val key = factory.generateSecret(keySpec)
        cek = Cek(KEY_LENGTH, SecretKeySpec(key.encoded, "AES"))
    }

    override fun provide(): Cek = cek

    companion object {
        const val ALGORITHM = "PBKDF2WithHmacSHA512"
        const val ITERATION_COUNT = 100000
        const val KEY_LENGTH = 128

        // we cannot generate salt since it has to be the same on every derivation.
        // however, each cipher will be initialized with its own IV, so re-using
        // the salt for key derivation should not be much of an issue as every file
        // will be encrypted with an own IV.
        val SALT = byteArrayOf(0x5A, 0x2F, 0x4D, 0x35, 0x2F, 0x55, 0x7A, 0x10)
    }
}
