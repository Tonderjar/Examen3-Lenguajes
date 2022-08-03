package lib

public class Cola : Secuencia {

    var cola  = mutableListOf<Int>()

    // Agrega un elemento a la coleccion
    override fun agregar(v: Int){
        cola.add(v)
    }

    // Elimina un elemento de la coleccion
    override fun remover() : Int{
        return cola.removeAt(0)
    }

    // Determina si la coleccion esta vacia.
    override fun vacia() : Boolean{
        return cola.size == 0
    }

    // Retorna un iterador de los elementos en la secuencia
    override operator fun iterator() : Iterator<Int>{
        return cola.listIterator()
    }

    // Retorna la representacion a string de la Cola
    override fun toString() : String{
        if(cola.size == 0){
            return "[]"
        }
        var str = "[" + cola[0].toString()
        for(i in 1..cola.size-1){
            str += ", " + cola[i].toString()
        }
        str += "]"
        return str
    }
}
