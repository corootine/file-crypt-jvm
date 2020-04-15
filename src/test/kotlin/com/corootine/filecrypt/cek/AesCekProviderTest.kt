package com.corootine.filecrypt.cek

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AesCekProviderTest {

    @Test
    fun `should generate the same key for the same secret`(){
        // Given
        val cekProvider = AesCekProvider()

        // When
        val secretKey1 = cekProvider.provide(charArrayOf('h', 'e', 'l', 'l', 'o'))
        val secretKey2 = cekProvider.provide(charArrayOf('h', 'e', 'l', 'l', 'o'))

        // Then
        assertEquals(secretKey1, secretKey2)
    }
}