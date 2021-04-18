/**
 * Der primary constructor führt das Property value ein.
 * Ohne das Schlüsselwort <code>open</code> wäre die Klasse
 * nicht ableitbar, d.h. final im Java Sprachgebrauch.
 */
open class InheritanceExample(var value : Int) {
    /**
     * Auch Properties können überschrieben werden:
     * Der default Wert kann sich ändern oder ein <code>val</code> kann
     * zum <code>var</code> werden, aber nicht andersherum.
     * Auch die <code>get</code> und <code>set</code> Methoden können
     * beim überschreiben geändert oder neu eingeführt oder weggelassen werden.
     */
    open val propVal : Double = Double.MAX_VALUE

    /**
     * Damit die Member Funktione überschrieben werden kann, muss auch sie mit <code>open</code>
     * eingeleitet werden.
     */
    open fun changeValue(changer : Int) {
        value += changer
    }
}

/**
 * Der primary constructor der abgeleiteten Klasse darf das Property value nicht mehr einführen,
 * muss es aber initialisieren - daher fehlt die <em>var</em> Angabe, der Wert wird
 * aber trotzdem initialisiert.
 * Ohne primary constructor müssen die secondary constructors für die Initialierung
 * von <code>value</value> sorgen.
 * Wir markieren diese Klasse wiederum mit <code>open</code> denn ansonsten wäre sie automatisch
 * final.
 */
open class DerivedClassExample(valueParam: Int) : InheritanceExample(valueParam) {
    val notChangeAble : Int = valueParam

    /**
     * Wir überschreiben hier das Property. Wichtig ist noch, dass diese Änderung des Propertys
     * nicht aktiv ist, wenn die Basisklasse initialisiert wird, was vor der abgeleiteten Klasse
     * passiert.
     */
    override val propVal: Double
        get() = super.propVal + 4.0

    /**
     * Der secondary constructor ruft den primary auf, da hier ein Aufruf <code>super(valueParam)</code>
     * nicht erlaubt ist. Das wäre dann der Fall, wenn es in der abgeleiteten Klasse keinen primary
     * constructor geben würde - siehe nächste Klasse.
     */
    constructor(valueParam: Int, notChanged: Int) : this(valueParam) {
        value
    }

    /**
     * Wir überschreiben die Member Funktion <code>changeValue</code> hier.
     * Ein überschreibende Member Funktion ist in weiteren abgeleiteten Klassen ebenfalls
     * überschreibbar, außer man markiert ist mit <code>final</code>
     */
    override fun changeValue(changer: Int) {
        // nicht notwendigerweise bisheriges Verhalten nutzen:
        super.changeValue(changer)
        // zusätzliche Aktion:
        value *= changer
    }
}

/**
 * Diese abgeleitete Klasse hat keinen primary constructor und muss daher im secondary die
 * Basisklasse über den <coce>super(valueParam)</code> Aufruf initialisieren.
 * Die Angabe von <code>final</code> bei der Klasse ist überflüssig, da ohne die Markierung
 * <code>open</code> die Klasse automatisch final ist.
 */
final class SecondDerivedClassExample : InheritanceExample {
    constructor(valueParam : Int) : super(valueParam)
}