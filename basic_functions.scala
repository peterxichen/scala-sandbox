object BasicFunctions {
    // input-less functions
    def hello() = "hello world"

    // full function
    def mult(x: Int, y: Int): Int = { x * y }

    def formatEuro(amt: Double) = f"€$amt%.2f"

    // early function exit
    def safeTrim(s: String): String = {
        if (s == null) return null
        s.trim()
    }

    // procedures
    def log(d: Double): Unit = println(f"$d%.2f")

    // recursive function, raises integer by positive exponent
    def power(x: Int, n: Int): Long = {
        if (n >= 1) x * power(x, n-1)
        else 1
    }
    
    // optimized for tail-recursion
    def power_tr(x: Int, n: Int, t: Int = 1): Long = {
        if (n < 1) t
        // recursive call must be last item
        else power_tr(x, n-1, x*t)
    }

    // nested function
    def max(a: Int, b: Int, c: Int) = {
        def max(x: Int, y: Int) = if (x > y) x else y
        max(a, max(b, c))
    }

    // vararg - match 0+ arguments from the caller
    def sum_vararg(items: Int*): Int = {
        var x = 0
        for (i <- items) x += i
        x
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

        println("\nExecuting procedure method...")
        println(log(1.2345))

        println("\nInvoking function with expression block...")
        println(formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 })

        println("\nRecursively calculating power...")
        println(power(2,10))
        println(power_tr(2,10))

        println("\nNested function...")
        println(max(3,4,5))

        println("\nSumming vararg...")
        println(sum_vararg(3,4,5))

        println("\nTerminating")
    }
}
