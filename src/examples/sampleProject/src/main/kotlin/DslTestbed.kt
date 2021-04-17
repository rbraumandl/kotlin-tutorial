class DslTestbed {
    class Outer {
        var innerNodes = mutableListOf<Inner>()

        fun inner(init: Inner.() -> Unit){
            val child = Inner()
            child.init()
            innerNodes.add(child)
        }

        fun show() : String {
            val lines = mutableListOf<String>()
            lines.add("Outer node")
            innerNodes.forEach(){
                lines.add(it.show())
            }
            return lines.joinToString(separator = "\n")
        }
    }

    class Inner() {
        val innerNodes = mutableListOf<InnerMost>()

        fun innerMost(weight: Double){
            val child = InnerMost(weight)
            innerNodes.add(child)
        }

        fun show() : String {
            val lines = mutableListOf<String>()
            lines.add("Inner node: ".prependIndent("  "))
            innerNodes.forEach(){
                lines.add(it.show())
            }
            return lines.joinToString(separator = "\n")
        }
    }

    class InnerMost(val weight: Double) {
        fun show() : String {
            return "InnerMost node: ".prependIndent("    ") + String.format("%+07.2g",weight)
        }
    }

    companion object {
        fun outer(init: Outer.() -> Unit) : String {
            val outer = Outer()
            outer.init()
            return outer.show()
        }
    }
}



fun main() {
    val structure =
        DslTestbed.outer {
            inner {
                innerMost(weight = 45.8889)
                innerMost(weight = -1938.4883)
            }
            inner {
                innerMost(weight = 22.0048)
                innerMost(weight = 234234.23423)
            }
        }
    println(structure)
}
