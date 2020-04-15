package com.corootine.filecrypt.cmd

import com.xenomachina.argparser.ArgParser
import java.io.File

class ParsedArgs(parser: ArgParser) {

    val mode by parser.mapping(
        "-e" to CryptoMode.ENCRYPT,
        "--encrypt" to CryptoMode.ENCRYPT,
        "-d" to CryptoMode.DECRYPT,
        "--decrypt" to CryptoMode.DECRYPT,
        help = "mode of operation"
    )

    val files by parser.adding("-f", "--file", help = "file to encrypt/decrypt") { File(this) }

    val directories by parser.adding("-r", "--directory", help = "directory to encrypt/decrypt") { File(this) }
}