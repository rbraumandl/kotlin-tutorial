class FunctionExample (val iMem : Int) {
    infix fun ifxFun(param : Int) : Int {
        return iMem + param;
    }
}

fun apply(c: String, f: (String) -> Int) : Int = f(c)

fun main() {
    val funEx = FunctionExample(200)
    println(funEx ifxFun 4)
    val lambda = { a:Int, b:Int ->
        val c = a + b
        val b = c*2
        b*3
    }
    println(lambda(2,3))
    val sum = arrayOf(1,2,3).map { it -> it * 2 }.sum()
}