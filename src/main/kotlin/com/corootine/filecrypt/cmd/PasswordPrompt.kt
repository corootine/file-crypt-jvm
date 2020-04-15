package com.corootine.filecrypt.cmd

object PasswordPrompt {

    private lateinit var password: CharArray

    fun prompt(): CharArray {
        val console = System.console()
        password = console.readPassword("Enter your password: ")
        return password
    }

    fun clear() {
        password.forEachIndexed { index, _ -> password[index] = '0' }
    }
}