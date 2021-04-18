private val shouldBeInitialized = Initializer.initialize()

public abstract class Initializer {
    abstract val iiMember : Int
    companion object {
        var initialized = false
        fun initialize() {
            initialized = true
        }
    }
}

fun main() {
    println("Something has been initialized: ${Initializer.initialized}")
}