package lib

interface Secuencia : Iterable<Int>{
    
    // Agrega un elemento a la coleccion
    fun agregar(v: Int)

    // Elimina un elemento de la coleccion
    fun remover() : Int

    // Determina si la coleccion esta vacia.
    fun vacia() : Boolean 

    //Retorna un iterador de los elementos en la secuencia
    override operator fun iterator() : Iterator<Int>
}
