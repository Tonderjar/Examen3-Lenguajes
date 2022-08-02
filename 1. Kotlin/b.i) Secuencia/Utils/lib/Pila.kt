package lib

public class Pila : Secuencia {

    var pila  = mutableListOf<Any>()

    // Agrega un elemento a la coleccion
    override fun agregar(v: Any){
        pila.add(0, v)
    }

    // Elimina un elemento de la coleccion
    override fun remover() : Any{
        return pila.removeAt(0)
    }

    // Determina si la coleccion esta vacia.
    override fun vacia() : Boolean{
        return pila.size == 0
    }

    //Retorna un iterador de los elementos en la secuencia
    override operator fun iterator() : Iterator<Any> {
        return pila.listIterator()
    }

    // Retorna la representacion a string de la Pila
    override fun toString() : String{
        if(pila.size == 0){
            return "[]"
        }
        var str = "[" + pila[0].toString()
        for(i in 1..pila.size-1){
            str += ", " + pila[i].toString()
        }
        str += "]"
        return str
    }
}
