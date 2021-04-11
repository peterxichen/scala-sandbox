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

        println("\nTerminating...")
    }
}