// collections - data structures for collecting one or more values of given type

object CollectionScripts{
    def main(args: Array[String]): Unit = {
        println("List, Sets, Maps")

        val color_list = List("red", "green", "blue", "purple")
        println(color_list)
        println(color_list.head)
        println(color_list(1))
        var x: Int = 1
        for (c <- color_list) { 
            println(x.toString + ' ' + c)
            x+=1
        }

        println("\nTerminating...")
    }
}