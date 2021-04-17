// ein top level const Property muss bei Deklaration initialisiert werden:
const val message : String = "Ein Test"

// entweder gibt der getter ein Wert zurück
val stringVar : String
    get() {
        return ""
    }
// oder es ist eine Initialisierung für top-level Properties notwendig:
val anotherStringVar : String = "Eins"

var numberVar : Int = 0

var numericVar : Int
    get() = 0
    set(value) {
        numberVar = value
    }

val rawString = """
    \n\n\t
    
    ein Test
""".trimIndent()

fun printRawString() : Unit {
    print(rawString)
}

// die folgende Property Definition ist ziemlich unsinnig, da belegte
// Werte niemals abgerufen werden können, da konstant eine 0 als Wert
// zurückgegeben wird:
var numericVar1 : Int = 3
    get() = 0
    set(value) {
        println("numericVar1 has value ${field} and will be set to ${value}")
        field = value
    }

class PropertiesPlayground (msg : String) {
    // Die Initialisierung von Objekten kann bis nach Konstruktor Aufruf verzögert werden, wenn
    // der modifier lateinit verwendet wird
    lateinit var message : String

    // secondary constructor:
    constructor(msg : String, count : Int) : this(msg) {
        message = msg
    }

    var testProperty : Int = 3
        // if not specified the default implementation of get is used
        set(value) {
            field = value // backing field of property
        }

    fun compute() : Int {
        testProperty = 4
        return testProperty * 2
    }
}

object PropertiesObject {
    // der const Modifier kann bei top level Properties oder in object Definitionen verwendet werden.
    const val t : Int = 5

}

fun arrayTest() {
    val stringArray : Array<String> = arrayOf("1", "2")
    println("Zugriff über eckige Klammern Operator: ${stringArray[0] == "1"}")
    stringArray.sort()
    // Arrays haben eine feste Länge, so dass bei einigen Funktionen auf Arrays neue Arrays erzeugt werden:
    val stringArray2 = stringArray.plus("3")
    // === ermittelt die Objektidentität, == die strukturelle Identität
    println("Sind die Arrays identisch: ${stringArray === stringArray2}")
    // == entspricht dem Vergleich mit der equals() Member Funktion
    println("Sind die Arrays gleich: ${stringArray == arrayOf("1","2")}")
    println("Sind die Arrays gleich: ${arrayOf("1","2").contentDeepEquals(stringArray)}")
    stringArray.forEach { s -> print(s) }
    println()
    println("----------")
    stringArray2.forEach { s -> print(s) }
    println()
    println("Arrays schneiden: ${stringArray2.sliceArray(0..1).contentDeepEquals(stringArray)}")
    }

fun main() {
    numericVar1 = 5
    println("numericVar1 has now the value ${numericVar1}")

    val localVar : Int = 9
    val pp = PropertiesPlayground("eins")
    println("Value of compute: ${pp.compute()}")

    numericVar1.apply{ println(this)}
    val pi: Double = 3.14
    println("Value of PI : ${pi}")

    println("Raw String: ${rawString}")

    arrayTest()
}
