import java.io.File

class File_IO(
    inputPath: String,
    outputPath: String
) : IO {

    private val inputFile = File(inputPath)
    private val outputFile = File(outputPath)
    private val lines = inputFile.readLines().toMutableList()
    private var index = 0

    override fun read(): String {
        if (index >= lines.size) return "stop"
        return lines[index++]
    }

    override fun write(text: String) {
        outputFile.appendText(text + "\n")  
    }
}