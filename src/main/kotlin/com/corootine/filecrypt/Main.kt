package com.corootine.filecrypt

import com.corootine.filecrypt.cmd.ParsedArgs
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

fun main(args: Array<String>) = mainBody {
    ArgParser(args).parseInto(::ParsedArgs).run {
        println(mode)
        println(password)
        println(files)
        println(directories)
    }
}