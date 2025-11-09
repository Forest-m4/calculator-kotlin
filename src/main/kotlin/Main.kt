import io.Console_IO
import io.File_IO
import io.IO
import utils.toBase
import java.io.PrintStream
import java.io.File

fun main() {

    // Вкл русский язык
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    println("Вы хотите использовать консоль (1) или файл (2)?")
    val choice = readln()

    val io: IO = if (choice == "2") {
        // очистить файл output перед записью
        File("output.txt").writeText("")
        File_IO("input.txt", "output.txt") // работа с файлами
    } else {
        Console_IO() // работа с консолью
    }

    val base = 2 //система исчил

    println("Введи выражения типа 12 + 5. Напиши stop чтобы выйти.")

    while (true) {
        val inputLine = io.read()
        val input = inputLine.replace(" ", "") // удаляем все пробелы

        if (input.lowercase() == "stop") {
            println("Выход из программы.")
            break
        }

        var result: Long = 0
        var errorMessage = ""
        var operator: Char? = null

        for (c in input) {
            when (c) {
                '+' -> { operator = '+'; break }
                '-' -> { operator = '-'; break }
                '*' -> { operator = '*'; break }
                '/' -> { operator = '/'; break }
            }
        }

        if (operator == null) {
            println("Ошибка: Оператор не найден")
            continue
        }

        try {
            val parts = input.split(operator)

            if (parts.size != 2) {
                throw Exception("Неверный формат")
            }

            val a = parts[0].toLongOrNull() ?: throw Exception("Первое число некорректно")
            val b = parts[1].toLongOrNull() ?: throw Exception("Второе число некорректно")

            result = when (operator) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                '/' -> {
                    if (b == 0L) throw Exception("Деление на ноль")
                    a / b
                }
                else -> throw Exception("Неизвестный оператор")
            }

        } catch (e: Exception) {
            errorMessage = e.message ?: "Неизвестная ошибка"
        }

        if (errorMessage != "") {
            io.write("Ошибка: $errorMessage")
        } else {
            val resultStr = result.toBase(base)
            io.write("Результат в двоичной системе: $resultStr")
        }
    }
}