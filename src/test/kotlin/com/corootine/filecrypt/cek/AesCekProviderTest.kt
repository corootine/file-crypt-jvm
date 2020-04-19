package com.corootine.filecrypt.cek

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AesCekProviderTest {

    @Test
    fun `should create 128 bit key`() {
        // Given
        val cekProvider = AesCekProvider()

        // When
        val cek = cekProvider.provide(charArrayOf('h', 'e', 'l', 'l', 'o'))

        // Then
        assertEquals(128, cek.keyLength)
    }

    @Test
    fun `should generate the same key for the same secret`() {
        // Given
        val cekProvider = AesCekProvider()

        // When
        val cek1 = cekProvider.provide(charArrayOf('h', 'e', 'l', 'l', 'o'))
        val cek2 = cekProvider.provide(charArrayOf('h', 'e', 'l', 'l', 'o'))

        // Then
        assertEquals(cek1, cek2)
    }
}