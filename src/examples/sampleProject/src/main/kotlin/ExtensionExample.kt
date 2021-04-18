/**
 * Wir werden diese Klasse per Extensions erweitern (auch wenn wir die Klasse
 * hier direkt im Zugriff haben und nicht auf diesen Mechanismus angewiesen wären.
 */
class ExtensionExample(var memberVar : Int = 4) {
}

/**
 * Erweiterung um diese Funktion.
 */
fun ExtensionExample.extendFun() {
    this.memberVar = 5
}

/**
 * Erweiterung um dieses Property
 */
val ExtensionExample.extMemberVar : Double
get() = 4.5

fun main() {
    val ext = ExtensionExample()
    println(ext.extMemberVar)
    println(ext.extendFun())
}

