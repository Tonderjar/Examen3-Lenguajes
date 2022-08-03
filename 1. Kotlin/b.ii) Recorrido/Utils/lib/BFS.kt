package lib

/* 
   Implementación del algoritmo BFS. 
   Con la creación de la instancia, se ejecuta el algoritmo BFS
   desde el vértice s
*/
public class BFS(override val g: Grafo) : Busqueda(g) {

    override var lista : Secuencia = Cola()
    override var visitado = mutableListOf<Boolean>()
    override var numVisitados = 0
    
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
        numVisitados = 0
        lista.agregar(g.mapa.getValue(d))
        visitado[g.mapa.getValue(d)] = true
        while(!lista.vacia()){
            var nodoActual = lista.remover()
            var adyacentes = g.adyacentes(nodoActual)
            for(lado in adyacentes){
                if(visitado[lado.b] == false){
                    numVisitados++
                    if(lado.b == g.mapa.getValue(h)){
                        return numVisitados
                    }
                    lista.agregar(lado.b)
                    visitado[lado.b] = true
                }
            }
        }
        return -1
    }
}
