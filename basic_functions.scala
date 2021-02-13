object BasicFunctions {
    // input-less functions
    def hello = "hello world"

    // full function
    def mult(x: Int, y: Int): Int = { x * y }

    // early function exit
    def safeTrim(s: String): String = {
        if (s == null) return null
        s.trim()
    }

    def main(args: Array[String]): Unit = {
        println("Executing basic functions:")
        println("\nInput-less function...")
        println(hello)

        val x = 3
        val y = 7
        println("\nMultiplying...")
        println(mult(x, y))

        val s = "    hello world      "
        println("\nTrimming string...")
        println(safeTrim(s))
    }
}
