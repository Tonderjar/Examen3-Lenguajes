package lib

public class Lado(val a: Int, val b: Int) {

    // Retorna el primer vértices del grafo
    fun cualquieraDeLosVertices() : Int {
        return this.a;
    }

    // Dado un vertice de un lado, devuelve el otro 
    fun elOtroVertice(w: Int) : Int {
        if(a == w){
            return b;
        }else if(b == w){
            return a;
        }else{
            throw RuntimeException("El vertice no pertenece al lado.");
        }
    }

    override fun toString() : String{
        var str = "(" + a.toString() + ", " + b.toString() + ")"
        return str
    }
}
