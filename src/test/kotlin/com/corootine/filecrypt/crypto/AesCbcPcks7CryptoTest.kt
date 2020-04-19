package com.corootine.filecrypt.crypto

import com.corootine.filecrypt.cek.AesCekProvider
import com.corootine.filecrypt.cmd.CryptoMode
import org.junit.jupiter.api.Test

internal class AesCbcPcks7CryptoTest {

    @Test
    fun `should encrypt small text data`() {
        // Given
        val plaintext = byteArrayOf(66, 67, 68, 69)
        val encrypter = AesCbcPcks7Crypto(AesCekProvider(charArrayOf('h', 'e', 'l', 'l', 'o')))

        // When
        val cipher = encrypter.init(CryptoMode.ENCRYPT)
        val buffer1 = encrypter.update(cipher, byteArrayOf(plaintext[0]))
        val buffer2 = encrypter.update(cipher, byteArrayOf(plaintext[1]))
        val buffer3  = encrypter.update(cipher, byteArrayOf(plaintext[2]))
        val buffer4 = encrypter.finish(cipher, byteArrayOf(plaintext[3]))

        val bufferFinal = buffer1 + buffer2 + buffer3 + buffer4

        val cipher2 = encrypter.init(CryptoMode.DECRYPT)
        val buffer21 = encrypter.update(cipher, bufferFinal.copyOfRange(0, 4))
        val buffer22 = encrypter.update(cipher, bufferFinal.copyOfRange(4, 8))
        val buffer23 = encrypter.update(cipher, bufferFinal.copyOfRange(8, 12))
        val buffer24 = encrypter.finish(cipher, bufferFinal.copyOfRange(12, 16))

        // Then
        val s = ""
    }

    fun `should encrypt large text data`() {
        // Given

        // When

        // Then
    }

    fun `should use a different iv on each encryption`() {
        // Given

        // When

        // Then
    }
}