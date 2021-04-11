// collections - data structures for collecting one or more values of given type

object CollectionScripts{
    def main(args: Array[String]): Unit = {
        println("List, Sets")

        val colors = List("red", "green", "blue", "purple")
        println(colors)
        println(colors.head)
        println(colors(1))
        var x: Int = 1
        for (c <- colors) { 
            println(x.toString + ' ' + c)
            x+=1
        }

        val primes = List(2, 3, 5, 7, 11)
        println(primes)
        println(primes(0) + primes(4))
        val first = primes.head
        val remaining = primes.tail
        println(first)
        println(remaining)

        // sample while loop implementation
        var i = primes
        while (! i.isEmpty) { print(i.head + ", "); i = i.tail}
        // recursive implementaiont
        def visit(i: List[Int]) {
            if (i.size > 0) {
                print(i.head + ", "); visit(i.tail)
            }
        }
        // lists end with an instance of Nil as terminus
        while (i != Nil) { print(i.head + ", "; i = i.tail)}

        val colorset = Set("red", "red", "green")
        println(colorset)

        println("\nforeach, map, reduce")
        colors.foreach( (c: String) => println(c))
        val sizes = colors.map( (c: String) => c.size)
        println(sizes)
        val sizes_plus_1 = colors.map( (c: String) => (c.size, 1))
        println(sizes_plus_1)
        val total = sizes.reduce( (a: Int, b: Int) => a + b)
        println(total)

        val cMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
        println(cMap)
        println(cMap("red"))
        println(cMap("red") | cMap("green"))
        println(cMap.contains("green"))
        for (c <- cMap) { println(c) }

        println("\nTerminating...")
    }
}