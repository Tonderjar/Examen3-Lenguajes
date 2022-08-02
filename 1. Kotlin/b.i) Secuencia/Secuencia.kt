import lib.*


fun main() {


    var lista = Pila()

    println("Prueba de Pila:")
    println()

    println("Agrego 1 a la pila.")
    lista.agregar(1)   
    println(lista.toString())

    println("Agrego 23 a la pila.") 
    lista.agregar(23)
    println(lista.toString())

    println("Remuevo un elemento de la pila.")
    lista.remover()
    println(lista.toString())

    println("Imprimo la pila.")
    println(lista.toString())

    println("Reviso si la pila esta vacia.")
    println(lista.vacia())
    println()

    var lista2 = Cola()

    println("Prueba de Cola:")
    println()

    println("Agrego 1 a la cola.")
    lista2.agregar(1)
    println(lista2.toString())

    println("Agrego 23 a la cola.")
    lista2.agregar(23)
    println(lista2.toString())

    println("Remuevo un elemento de la cola.")
    lista2.remover()
    println(lista2.toString())

    println("Remuevo un elemento de la cola.")
    lista2.remover()
    println(lista2.toString())

    println("Imprimo la cola.")
    println(lista2.toString())

    println("Reviso si la cola esta vacia.")
    println(lista2.vacia())
}
