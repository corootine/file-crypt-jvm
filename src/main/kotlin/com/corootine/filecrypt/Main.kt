package com.corootine.filecrypt

import com.corootine.filecrypt.cek.AesCekProvider
import com.corootine.filecrypt.cmd.ParsedArgs
import com.corootine.filecrypt.cmd.PasswordPrompt
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::ParsedArgs)
    val password = PasswordPrompt.prompt()
    val cek = AesCekProvider().provide(password)
    PasswordPrompt.clear()
}