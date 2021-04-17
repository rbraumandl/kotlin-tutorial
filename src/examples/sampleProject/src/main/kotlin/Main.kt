fun main(args: Array<String>) {
    println("Hello world ${args.size}")
}

const val myConstVal : Int = 100
val c : Int = 6

class MyClass (intMember : Int) {
    var iMember : Int = intMember
    val t : Int = 5
    
    fun increment() {
	iMember = iMember + myConstVal
    }
}
