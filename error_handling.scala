object ErrorHandlingScripts{
    def loopAndFail(end: Int, failAt: Int): Int = {
        for (i <- 1 to end) {
            println(s"$i")
            if (i == failAt) {
                throw new Exception("STOP")
            }
        }
        end
    }
    def main(args: Array[String]): Unit = {
        println("Try collection - error handling as collection management")
        loopAndFail(10, 3)
        println("Terminating...")
    }
}