import lib.*
import kotlin.io.*

fun main() {

    var s = true
    var atomos = mutableMapOf<String, Int>()
    var nAtomos = 0

    var variables = mutableSetOf<String>()

    var estructuras = mutableMapOf<String, Int>()
    var nEstructuras = 0

    var hechos = mutableMapOf<String, Int>()
    var nHechos = 0

    var reglas = mutableMapOf<String, Int>()
    var nReglas = 0

    var lHechos = mutableListOf<List<String>>()

    var lReglas = mutableListOf<List<String>>()

    var cond = -1

    while(s){
        
        print("Introduzca su siguiente entrada: ")
        val input = readLine()!!
        print("\n")

        var argumentos = input.split(" ")
        
        if(argumentos[0] == "DEF"){

            //Verifico si la entrada es valida para definiciones
            cond = Utilidades.tipoDef(argumentos)

            //Si la definicion es incorrecta
            if(cond == -1){
                println("Definicion incorrecta")
                continue
            
            //Definicion de hechos como padre(a, b)
            } else if(cond == 0){
                var strAux1 = argumentos[1]
                var strAux2 = argumentos[2]
                strAux1 = strAux1.replace(",", "")
                strAux1 = strAux1.replace("(", " ")
                strAux2 = strAux2.replace(")", "")
                val strAux = strAux1 + " " + strAux2
                lHechos.add(strAux.split(" "))
                hechos.put(strAux, nHechos)
                nHechos++
                println(lHechos)

            //Definicion de hechos como true
            } else if (cond == 1){
                var lAux = listOf(argumentos[1])
                lHechos.add(lAux)
                hechos.put(argumentos[1], nHechos)
                nHechos++
                println(lHechos)

            //Definicion de reglas
            } else {
                var auxReglas = ""
                for(i in 0..((argumentos.size-1)/2)-1){
                    var strAux1 = argumentos[2*i+1]
                    var strAux2 = argumentos[2*i+2]
                    strAux1 = strAux1.replace(",", "")
                    strAux1 = strAux1.replace("(", " ")
                    strAux2 = strAux2.replace(")", "")
                    val strAux = strAux1 + " " + strAux2
                    auxReglas = auxReglas + strAux + " "
                    if(!auxReglas.split(" ")[1][0].isUpperCase()){
                        variables.add(strAux[1].toString())
                    }
                    if(!auxReglas.split(" ")[2][0].isUpperCase()){
                        variables.add(strAux[2].toString())
                    }
                }
                lReglas.add(auxReglas.split(" "))
                reglas.put(auxReglas, nReglas)
                nReglas++
                println(lReglas)
                println(reglas)
            }
        } else if(argumentos[0] == "ASK"){

            //Verifico si la entrada es valida para consultas
            cond = Utilidades.tipoAsk(argumentos)

            //Si la consulta es incorrecta
            if(cond == -1){
                println("Consulta incorrecta")

            //Si ambos argumentos del predicado son constantes
            } else if(cond == 0){ 
                var ind = -1
                var strAux1 = argumentos[1]
                var strAux2 = argumentos[2]
                strAux1 = strAux1.replace(",", "")
                strAux1 = strAux1.replace("(", " ")
                strAux2 = strAux2.replace(")", "")
                var strAux = strAux1 + " " + strAux2
                try{
                    ind = hechos.getValue(strAux)
                } catch(error: java.util.NoSuchElementException){
                    println("false")
                }
                if(ind != -1){
                    println("true")
                }

            //Si solo el primer argumento es variable
            } else if(cond == 1){
                var soluciones = obtenerSoluciones(argumentos, lHechos)
                if(soluciones.size != 0){
                    println("Satisfacible cuando '" + args[1] + "' = '" + soluciones[0] + "'. Que desea hacer?")
                    soluciones.removeAt(0)
                }

                ////////////Funcion args falta!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                input = readLine()!!
                while(input == "RECHAZAR"){
                    if(soluciones.size != 0){
                        println("Satisfacible cuando '" + args[1] + "' = '" + soluciones[0] + "'. Que desea hacer?")
                        soluciones.removeAt(0)
                    } else {
                        println("No es satisfacible")
                        break
                    }
                    input = readLine()!!
                }
            //Si solo el segundo argumento es variable
            } else if(cond == 2){

            //Si ambos argumentos son variables
            } else {

            }
        } else if(argumentos[0] == "SALIR"){
            s = false
        } else {
            println("Entrada invalida.")
        }
    }
    
}