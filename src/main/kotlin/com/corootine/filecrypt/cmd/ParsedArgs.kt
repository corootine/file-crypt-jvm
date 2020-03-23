package com.corootine.filecrypt.cmd

import com.xenomachina.argparser.ArgParser

class ParsedArgs(parser: ArgParser) {
    val mode by parser.mapping(
        "-e" to  CryptoMode.ENCRYPT,
        "--encrypt" to  CryptoMode.ENCRYPT,
        "-d" to CryptoMode.DECRYPT,
        "--decrypt" to CryptoMode.DECRYPT,
        help = "mode of operation")

    val password by parser.storing("-p", "--password", help = "password used for encryption/decryption")

    val files by parser.adding("-f", "--file", help = "file to encrypt/decrypt")

    val directories by parser.adding("-r", "--directory", help = "directory to encrypt/decrypt")
}