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

        // mutable collections
        println("\nMutable collections")
        val m = Map("AAPL" -> 600, "MSFT" -> 100)
        val n = m - "AAPL" + ("GOOG" -> 2000)
        println(m)
        println(n)

        println("\nBuffer general purpose mutable seuquence")
        val nums_buffer = collection.mutable.Buffer(1)
        for (i <- 1 to 10) nums_buffer += i
        println(nums_buffer)
        println(nums_buffer.toList)

        println("\nCollection builders")
        val temp_builder = Set.newBuilder[Char]
        temp_builder += 'j'
        println(temp_builder)
        temp_builder ++= List('k', 'l')
        println(temp_builder)
        println(temp_builder.result)

        println("\nArrays")
        val color_array = Array("red", "green", "blue")
        println(colors(2))

        println("\nStreams")
        // lazy collection, generated from 1+ starting elements and recursive function
        def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i+1))
        val stream = inc(1)
        println(stream)
        val stream_list = stream.take(3).toList
        println(stream_list)
        println(stream)

        println("\nMonadic collections")
        println("\nTerminating...")
    }
}