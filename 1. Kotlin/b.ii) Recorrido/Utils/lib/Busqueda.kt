package lib

abstract class Busqueda(open val g: Grafo) {

    abstract var lista : Secuencia
    abstract var visitado : MutableList<Boolean>
    abstract var numVisitados : Int
    
    /*
    * Retorna el numero de nodos explorados desde d hasta
    * h. Si h no es alcanzable desde d, retorna -1.
    */
    open fun buscar(d: Int, h: Int) : Int{
        for(i in 0..g.obtenerNumeroDeVertices()-1){
            visitado.add(false)
        }
        lista.agregar(g.mapa.getValue(d))
        visitado[g.mapa.getValue(d)] = true
        while(!lista.vacia()){
            var nodoActual = lista.remover()
            numVisitados++
            if(nodoActual == g.mapa.getValue(h)){
                return numVisitados 
            }
            var adyacentes = g.adyacentes(nodoActual)
            for(lado in adyacentes){
                if(visitado[lado.b] == false){
                    lista.agregar(lado.b)
                    visitado[lado.b] = true
                }
            }
        }
        return -1
    }

}
