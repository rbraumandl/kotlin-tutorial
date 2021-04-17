class FunctionExample (val iMem : Int) {
    infix fun ifxFun(param : Int) : Int {
        return iMem + param;
    }
}

fun main() {
    val funEx = FunctionExample(200)
    println(funEx ifxFun 4)
}