import lib.*


fun main() {


    /* 
    
    Grafo ejemplo:
    
            5
           / \
          8  13
         /     \
        2      21
       /
      78
     /
    33
    
    */
    
    //El DFS hace el recorrido en profundidad hacia la derecha primero
    
    //Inicializo el grafo
    var g = Grafo()
    
    //Agrego vertices:
    g.agregarVertice(5)
    g.agregarVertice(8)
    g.agregarVertice(2)
    g.agregarVertice(78)
    g.agregarVertice(33)
    g.agregarVertice(13)
    g.agregarVertice(21)

    //Agrego lados:
    var lado = Lado(5, 8)
    g.agregarLado(lado)
    lado = Lado(8, 2)
    g.agregarLado(lado)
    lado = Lado(2, 78)
    g.agregarLado(lado)
    lado = Lado(78, 33)
    g.agregarLado(lado)
    lado = Lado(5, 13)
    g.agregarLado(lado)
    lado = Lado(13, 21)
    g.agregarLado(lado)

    println()

    println("Grafo:")
    println()
    println(g)

    //Pruebas:
    var bfs = BFS(g)
    var dfs = DFS(g)
    
    println("Pruebas:")
    println()

    println("Numero de vertices explorados de 5 a 33 con BFS")
    println(bfs.buscar(5, 33))    
    
    println("Numero de vertices explorados de 5 a 33 con DFS")
    println(dfs.buscar(5, 33))

    println("Numero de vertices explorados de 5 a 21 con BFS")
    println(bfs.buscar(5, 21))    
    
    println("Numero de vertices explorados de 5 a 21 con DFS")
    println(dfs.buscar(5, 21))

    println("Numero de vertices explorados de 2 a 21 con BFS")
    println(bfs.buscar(2, 21))    
    
    println("Numero de vertices explorados de 2 a 21 con DFS")
    println(dfs.buscar(2, 21))

    println()
}
