package io

class ConsoleIo : IO {
    override fun read(): String {
        return readln()  // читает строку с клавиатуры
    }

    override fun write(text: String) {
        println(text)    // выводит текст в консоль
    }
}