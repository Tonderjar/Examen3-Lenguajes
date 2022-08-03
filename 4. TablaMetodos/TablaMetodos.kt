import lib.*
import kotlin.io.*

fun main() {

    var s = true

    var nomClases = mutableListOf<String>()
    var clases = mutableListOf<MutableList<String>>()
    var jerarquia = mutableMapOf<String, String>()
    var mapaClases = mutableMapOf<String, Int>()
    var cont = 0
    var indice : Int

    while(s){
        
        print("Introduzca su siguiente entrada: ")
        var input = readLine()!!
        print("\n")

        var argumentos = input.split(" ")
        
        if(argumentos[0] == "CLASS"){
            if(argumentos.size == 1 || argumentos.size == 2){
                println("Clase invalida")
            } else{
                if(!argumentos.contains(":")){

                    // Si ya existe una clase con ese nombre
                    if(nomClases.contains(argumentos[1])){
                        println("Ya existe una clase con ese nombre")
                        continue
                    }

                    // Si hay algun metodo repetido
                    var s1 = argumentos.drop(2).distinct()
                    if(s1.size != argumentos.size-2){
                        println("Hay funciones repetidas para la misma clase")
                        continue
                    }

                    var clase = mutableListOf<String>()
                    for(i in 1..argumentos.size-1){
                        clase.add(argumentos[i])
                    }

                    clases.add(clase)
                    nomClases.add(clase[0])
                    mapaClases.put(clase[0], cont)
                    cont++
                    println("Clase "+clase[0]+" definida correctamente")

                } else {

                    // Si ya existe una clase con ese nombre
                    if(nomClases.contains(argumentos[1])){
                        println("Ya existe una clase con ese nombre")
                        continue
                    }

                    // Si hay algun metodo repetido
                    var s2 = argumentos.drop(2).distinct()
                    if(s2.size != argumentos.size-2){
                        println("Hay funciones repetidas para la misma clase")
                        continue
                    }

                    jerarquia.put(argumentos[1],argumentos[2])

                    // Si se crea un ciclo jerarquico
                    try{
                        jerarquia.getValue(jerarquia.getValue(argumentos[1])) == argumentos[1]
                        println("No se puede agregar la clase, forma un ciclo jerarquico.")
                        jerarquia.remove(argumentos[1])
                        continue
                    } catch(error:NoSuchElementException){}

                    // Si la clase padre no existe
                    if(!nomClases.contains(argumentos[3])){
                        println("La clase padre no ha sido definida anteriormente")
                        continue
                    }

                    var clase = mutableListOf<String>()
                    for(i in 1..argumentos.size-1){
                        if(argumentos[i] != ":"){
                            clase.add(argumentos[i])
                        }
                    }           
                    
                    clases.add(clase)
                    nomClases.add(clase[0])
                    mapaClases.put(clase[0], cont)   
                    cont++
                    jerarquia.put(clase[0], clase[1]) 
                    println("Clase "+clase[0]+" definida correctamente")

                }
            }
            
        } else if(argumentos[0] == "DESCUBRIR"){
            if(argumentos.size == 1 || argumentos.size > 2){
                println("Consulta invalida")
            } else{
                try{
                    indice = mapaClases.getValue(argumentos[1])
                } catch(error: NoSuchElementException){
                    println("El nombre del tipo no existe")
                    continue
                }
                if(clases[indice].size == 3){
                    for(i in 1..clases[indice].size-1){
                        println(clases[indice][i]+" -> "+clases[indice][0]+" :: "+clases[indice][i])
                    }
                } else{
                    var heredadosDistintos : MutableList<Pair<String, String>>
                    heredadosDistintos = Utilidades.metodosPadres(clases[mapaClases.getValue(clases[indice][1])][0], mapaClases, clases, jerarquia, mutableListOf<Pair<String, String>>())
                    for(elem in heredadosDistintos){
                        if(clases[indice].drop(2).contains(elem.first)){
                            heredadosDistintos.remove(elem)
                        }
                    }
                    for(i in heredadosDistintos.size-1 downTo 0){ 
                        println(heredadosDistintos[i].first+" -> "+heredadosDistintos[i].second+" :: "+heredadosDistintos[i].first)
                    }
                    for(i in 2..clases[indice].size-1){
                        println(clases[indice][i]+" -> "+clases[indice][0]+" :: "+clases[indice][i])
                    }
                }
            }           
        } else if(argumentos[0] == "SALIR"){
            s = false
        } else {
            println("Entrada invalida.")
        }
    }
    
}
