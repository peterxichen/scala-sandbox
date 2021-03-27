object FirstClassFunctions {
    def main(args: Array[String]): Unit = {
        println("Executing first class functions:")

        def double(x: Int): Int = x * 2
        // value has a type (Int) => Int
        val myDouble: (Int) => Int = double
        val myDoubleCopy = myDouble
        
        println("\nDefining values of type \"function\"")
        println(double(2))
        println(double(myDouble(2)))
        println(double(myDoubleCopy(2)))

        // _ as placeholder for invocation 
        val myDoubleWildcard = double _
        println(myDoubleWildcard(2))

        // explicit function type
        def max(a: Int, b: Int) = if (a>b) a else b
        val myMax: (Int, Int) => Int = max
        println(myMax(1,2))

        // Unit type
        def logString() = "=" * 50 + "\nstring\n" + "=" * 50
        val myLogString: () => String = logString
        println(myLogString())

        println("\nTerminating.")
    }
}