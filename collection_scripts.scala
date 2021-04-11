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
        println(List())
        val nillist = List()
        println(nillist == Nil)
        val single_list: List[String] = List("o")
        println(single_list.tail)
        while (i != Nil) { print(i.head + ", "); i = i.tail }

        // cons operator
        val nums = 1 :: 2 :: 3 :: Nil
        println(nums)
        println(Nil.::(10))
        println(2 :: nums)

        // list arithmetic
        // List is immutable, operations return new List
        println(List(1, 2, 3, 4) filter (_ > 2))
        println(List(1, 2, 3, 4) partition (_ < 3))
        println(List("hello", "goodbye", "hellogoodbye") sortBy (_.size))

        // corollary operations
        val nums2 = List(1, 2, 3, 4, 5, 6, 7, 8)
        println(nums2 :+ 9)
        println(nums2 takeRight 3)
        println(nums2 dropRight 3)

        // Set
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

        println("\nMapping lists")

        println("\nTerminating...")
    }
}