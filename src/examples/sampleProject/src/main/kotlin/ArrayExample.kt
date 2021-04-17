class ArrayExample(var intArray: IntArray = intArrayOf(1,2,3)) {
    /**
     * Ein Beispiel für eine inline function mit Nutzung eines reified Type Parameters
     * und mit Nutzung von Reflection (::class), wofür die Nutzung der Bibliothek
     * kotlin-reflect notwendig ist. Letztere muss im Classpath in der Regel separat
     * eingebunden werden.
     */
    inline fun <reified T> showMembers() = T::class.members.forEach{ m -> println(m) }
}

fun main() {
    val arrayExample = ArrayExample()
    arrayExample.intArray.forEach { ia -> println(ia) }
    arrayExample.showMembers<String>()

    val intArray = arrayOf(1,2,3)
    println(intArray.fold(0,{acc:Int, i:Int -> acc + i}))
}