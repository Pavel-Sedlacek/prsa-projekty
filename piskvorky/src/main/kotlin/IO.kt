object IO {
    fun readInt(s: String): Int = outLn("$s:").let { readln().toIntOrNull() ?: -1 }
    fun readStrOption(s: String, options: Iterable<String>): String =
        outLn("$s[options: ${options.joinToString(",")}]:").let { options.find { it == readln() } ?: options.first() }
    fun readStr(s: String): String = outLn("$s:").let { readln() }

    fun out(s: String = "") = print(s)
    fun out(s: Char) = print(s)

    fun outLn(s: String = "") {
        println(s)
    }
}
