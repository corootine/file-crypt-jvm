package com.corootine.filecrypt.cek

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AesCekProviderTest {

    @Test
    fun `should create 128 bit key`() {
        // Given
        val cekProvider = AesCekProvider(charArrayOf('h', 'e', 'l', 'l', 'o'))

        // When
        val cek = cekProvider.provide()

        // Then
        assertEquals(128, cek.keyLength)
    }

    @Test
    fun `should generate the same key for the same secret`() {
        // When
        val cek1 = AesCekProvider(charArrayOf('h', 'e', 'l', 'l', 'o')).provide()
        val cek2 = AesCekProvider(charArrayOf('h', 'e', 'l', 'l', 'o')).provide()

        // Then
        assertEquals(cek1, cek2)
    }
}