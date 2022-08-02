package lib

interface Secuencia : Iterable<Any>{
    
    // Agrega un elemento a la coleccion
    fun agregar(v: Any)

    // Elimina un elemento de la coleccion
    fun remover() : Any

    // Determina si la coleccion esta vacia.
    fun vacia() : Boolean 

    //Retorna un iterador de los elementos en la secuencia
    override operator fun iterator() : Iterator<Any>
}
