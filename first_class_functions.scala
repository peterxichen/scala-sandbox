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

        // higher order function:
        // function that has value of function type as input or output
        // e.g. function acting on string only if string is not null
        def safeString(s: String, f: String => String) = {
            if (s != null) f(s) else s
        }
        def doubleString(s:String) = {
            s + s
        }
        println("\nHigher order function:")
        println(safeString(null, doubleString))
        println(safeString("test", doubleString))
        println(safeString("test", _.reverse)) // placeholder
        println(safeString("test", (s:String) => s.reverse))
        println(safeString("test", s => s.reverse)) // compiler inferred type

        // function literal, lambda (lacks a name)
        println("\nFunction literals:")
        val doubler = (x: Int) => x*2
        println()

        // function -> function value
        def max2(a: Int, b: Int) = {
            if (a > b) a else b
        }
        val maximize: (Int, Int) => Int = max2
        println(maximize(10,20))

        // function literal
        val mazimize = (a: Int, b: Int) => if (a > b) a else b
        println(maximize(10, 20))

        // placeholders
        println("\nUsing placeholders:")
        def combine(x: Int, y: Int, f: (Int, Int) => Int) = {
            f(x,y)
        }
        println(combine(321, 123, _ + _))
        println(combine(321, 123, _ * _))

        def triplCombine[InType, OutType](a: InType, b: InType, c: InType, f: (InType, InType, InType) => OutType) = {
            f(a, b, c)
        }
        println(triplCombine[Int, Int](123, 456, 789, _ * _ / _))
        println(triplCombine[Int, Double](123, 456, 789, _ * _ / _))
        println(triplCombine[Int, Boolean](123, 456, 789, _ * _ / _ > 10))

        // partial placeholder
        def factorOf(x: Int, y: Int) = {
            y % x == 0
        }
        val f = factorOf _
        println(f(3, 7))
        val multipleOf3 = factorOf(3, _: Int)
        println(multipleOf3(9))

        // split into multipl parameter lists (currying)
        def factorOfMulti(x: Int)(y: Int) = {
            y % x == 0
        }
        val isEven = factorOfMulti(2) _
        println(isEven(32))

        // by-name parameters
        // function or value can be passed
        // if fuction is passed then function is invoked for every usage
        def byname1(x: => Int) = {
            println("Pass 1 for " + x)
            x
        }
        def byname2(x: => Int) = {
            println("Pass 2 for " + x)
            x // <- executes here each pass
        }
        println("\nBy-name parameters:")
        println(byname1(byname2(5)))

        // partial functions
        // only takes limited parameters
        val statusHandler: Int => String = {
            case 200 => "OK"
            case 400 => "Client Error"
            case 500 => "Server Error"
        }
        println("\nTesting partial parameters:")
        println(statusHandler(200))
        println(statusHandler(400))
        println(statusHandler(500))
        try {
            statusHandler(100)
        }
        catch {
            case e : Throwable => println("Caught error... " + e) 
        }

        // breaking parameters into function literal blocks
        def safeStringSplit(s: String)(f: String => String) = {
            if (s!=null) f(s) else s
        }
        val result_string = safeStringSplit("first") { s =>
            val temp = s + "second"
            temp.toUpperCase
        } // invoked with block syntax
        println("\nTestng function literal parameters:")
        println(result_string)
        println("\nTerminating.")
    }
}