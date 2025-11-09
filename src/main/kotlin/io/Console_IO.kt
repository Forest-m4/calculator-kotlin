package io

class Console_IO : IO {
    override fun read(): String {
        return readlnOrNull() ?: ""
    }

    override fun write(text: String) {
        println(text)
    }
}