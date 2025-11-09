import io.Console_IO
import io.IO
import utils.toBase
import java.io.PrintStream

fun main() {

    // Вкл русский язык
    System.setOut(PrintStream(System.out, true, "UTF-8"))
    val io: IO = Console_IO()
    val base = 2 //система исчил

    println("Введи выражения типа 12 + 5. Напиши stop чтобы выйти.")

    while (true) {
        val inputLine = io.read()
        val input = inputLine.replace(" ", "") // удаляем все пробелы
        
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

            val a = parts[0].toLongOrNull() ?: throw Exception("Первое число некорректно")
            val b = parts[1].toLongOrNull() ?: throw Exception("Второе число некорректно")

            result = when (operator) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                '/' ->  a / b

                else -> throw Exception("Неизвестный оператор")
            }

        } catch (e: Exception) {
            errorMessage = e.message ?: "Неизвестная ошибка"
        }

        if (errorMessage != "") {
            println("Ошибка: $errorMessage")
        } else {
            val resultStr = result.toBase(base)
            println("Результат в двоичной системе: $resultStr")
        }
    }
}