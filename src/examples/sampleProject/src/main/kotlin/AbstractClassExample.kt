abstract class AbstractClassExample (val state : String) {
    abstract fun toOverride(param : Int)
}

class DerivedFromAbstract : AbstractClassExample {

    constructor(state : String) : super(state){

    }

    override fun toOverride(param: Int) {
        TODO("Not yet implemented")
    }

}