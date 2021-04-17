import kotlin.random.Random

class Obscure {

    /**
     * Das zu implementierende Interface wird als Function Type angegeben, was bedeutet die
     * Klasse muss eine Funktion diesen Type implementieren.
     */
    class ClassWithFunctionTypeAsInterfaceItImplements : () -> Int {
        override fun invoke(): Int {
            return Random.nextInt()
        }

    }
}

fun main() {
    val oc : Obscure.ClassWithFunctionTypeAsInterfaceItImplements = Obscure.ClassWithFunctionTypeAsInterfaceItImplements()
    println(oc.invoke())
}