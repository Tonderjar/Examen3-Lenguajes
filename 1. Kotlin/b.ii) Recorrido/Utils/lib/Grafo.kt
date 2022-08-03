package lib

public class Grafo : Iterable<Lado> {
    
  var listaAdyacencias = mutableListOf<MutableList<Int>>() //Representacion del grafo
  var listaLados = mutableListOf<Lado>() 
  var aux2 = mutableListOf<Lado>() //Lista auxiliar para devolver iterables sobre ella
  var tostring = "Vertice -> Adyacentes\n" //Contendra la representacion del grafo en string
  var mapa = mutableMapOf<Int, Int>()
  var mapaInv = mutableMapOf<Int, Int>()
  var nVertices = 0

  //Agrega un vertice al grafo
  fun agregarVertice(id: Int) {
    listaAdyacencias.add(mutableListOf<Int>())
    mapa.put(id, nVertices)
    mapaInv.put(nVertices, id)
    nVertices++
  }

  //Agrega un lado al grafo
  fun agregarLado(lado: Lado) : Boolean {
    for(i in 0..listaAdyacencias[mapa.getValue(lado.a)].size-1){
      if(listaAdyacencias[mapa.getValue(lado.a)][i] == mapa.getValue(lado.b)){
        return false 
      }
    }
    listaAdyacencias[mapa.getValue(lado.a)].add(mapa.getValue(lado.b))
    listaAdyacencias[mapa.getValue(lado.b)].add(mapa.getValue(lado.a))
    listaLados.add(lado)
    return true
  }

  // Retorna el número de lados del grafo
  fun obtenerNumeroDeLados() : Int {
    return listaLados.size
  }

  // Retorna el número de vértices del grafo
  fun obtenerNumeroDeVertices() : Int {
    return listaAdyacencias.size
  }

  /* 
  Retorna los adyacentes de v, en este caso los lados que tienen como vértice inicial a v. 
  Si el vértice no pertenece al grafo se lanza una RuntimeException.
  */
  fun adyacentes(v: Int) : Iterable<Lado> {
    if(v == -1){
        throw RuntimeException("El vertice no forma parte del grafo")
    }
    aux2.clear()
    for(i in 0..listaAdyacencias[v].size-1){
        var lado = Lado(v,listaAdyacencias[v][i])
        aux2.add(lado)
    }
    return aux2.asIterable()
  }

  override fun toString() : String{
    for(i in 0..listaAdyacencias.size-1){
      tostring = tostring + mapaInv.getValue(i).toString()
      for(k in 0..listaAdyacencias[i].size-1){
        tostring = tostring + " - "+ mapaInv.getValue(listaAdyacencias[i][k]).toString()
      }
      tostring = tostring + "\n"
    }
    return tostring
  }

  /* 
  Retorna un iterador de los lados del grafo.
  El iterador debe ser creado en clase que implementa esta interface.  
  */
  override operator fun iterator() : Iterator<Lado> {
    return listaLados.listIterator()
  }
}