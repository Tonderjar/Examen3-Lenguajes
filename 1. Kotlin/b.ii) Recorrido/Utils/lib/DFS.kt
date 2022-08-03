package lib

/* 
   Implementación del algoritmo DFS. 
   Con la creación de la instancia, se ejecuta el algoritmo DFS
   desde todos los vértices del grafo
*/
public class DFS(override val g: Grafo) : Busqueda(g) {

    override var lista : Secuencia = Pila()
    override var visitado = mutableListOf<Boolean>()
    override var numVisitados = -1
    
    init{
        for(i in 0..g.obtenerNumeroDeVertices()-1){
            visitado.add(false)
        }
    }

    override fun buscar(d: Int, h: Int) : Int {
        for(i in 0..g.obtenerNumeroDeVertices()-1){
            visitado[i] = false
        }
        while(lista.vacia() == false){
            lista.remover()
        }
        numVisitados = -1
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
