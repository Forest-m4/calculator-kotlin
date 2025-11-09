package io

import org.w3c.dom.Text

interface IO {
    fun read(): String
    fun write(text: String)
}