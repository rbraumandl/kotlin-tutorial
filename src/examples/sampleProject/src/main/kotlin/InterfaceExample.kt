interface InterfaceExample {
    /**
     * Dieses Property ist abstrakt.
     */
    val firstProp : Int

    val secondProp : Int
    get() = 42

    /**
     * Diese Funktion ist abstrakt.
     */
    fun firstInterfaceFunction(param1 : Double) : Int

    /**
     * Diese Funktion
     */
    fun secondInterfaceFunction(param1 : Int, param2 : Double) : Int {
        return param1 * firstInterfaceFunction(param2)
    }
}

/**
 * Wir überschreiben das erste Property mit dem primary constructor
 * das erste Property des Interfaces.
 */
class ImplementInterface(override val firstProp : Int = 55) : InterfaceExample {

    override val secondProp: Int
        get() = super.secondProp + firstProp

    /**
     * Wir überschreiben die abstrakte Funktion.
     */
    override fun firstInterfaceFunction(param1: Double): Int {
        return param1.toInt()
    }

    /**
     * Wir überschreiben auch nicht notwendigerweise die implementierte Funktion.
     */
    override fun secondInterfaceFunction(param1: Int, param2: Double): Int {
        return super.secondInterfaceFunction(param1, param2) + 2
    }
}