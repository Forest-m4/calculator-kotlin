package utils

fun Long.toBase(base: Int): String {
    if (this == 0L) return "0"

    var num = this
    val sb = StringBuilder()
    val symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    while (num > 0) {
        val remainder = (num % base).toInt()
        sb.append(symbols[remainder])
        num /= base
    }

    return sb.reverse().toString()
}