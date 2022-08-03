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
        var input = readLine()!!
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
                var args = Utilidades.args(argumentos, 1)
                hechos.put(args, nHechos)
                lHechos.add(args.split(" "))
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
                    var args = Utilidades.args(argumentos, 2*i+1)
                    auxReglas = auxReglas + args + " "
                    if(args.split(" ")[1][0].isUpperCase()){
                        variables.add(args.split(" ")[1])
                    }
                    if(args.split(" ")[2][0].isUpperCase()){
                        variables.add(args.split(" ")[2])
                    }
                }
                auxReglas = auxReglas.dropLast(1)
                lReglas.add(auxReglas.split(" "))
                reglas.put(auxReglas, nReglas)
                nReglas++
                println(lReglas)
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
                var args = Utilidades.args(argumentos, 1)
                try{
                    ind = hechos.getValue(args)
                } catch(error: java.util.NoSuchElementException){
                    println("false")
                }
                if(ind != -1){
                    println("true")
                }

            //Si solo el primer argumento es variable
            } else if(cond == 1){
                var arg = Utilidades.args(argumentos, 1)
                var args = arg.split(" ")
                var soluciones = Utilidades.obtenerSoluciones1(args, lHechos, lReglas)
                if(soluciones.size != 0){
                    println("Satisfacible cuando '" + args[1] + "' = '" + soluciones[0] + "'. Que desea hacer?")
                    soluciones.removeAt(0)

                    //Pido una respuesta a la primera solucion
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
                }

            //Si solo el segundo argumento es variable
            } else if(cond == 2){
                // var arg = Utilidades.args(argumentos, 1)
                // var args = arg.split(" ")
                // var soluciones = obtenerSoluciones2(args, lHechos)
                // if(soluciones.size != 0){
                //     println("Satisfacible cuando '" + args[2] + "' = '" + soluciones[0] + "'. Que desea hacer?")
                //     soluciones.removeAt(0)
                    
                //     //Pido una respuesta a la primera solucion
                //     input = readLine()!!
                //     while(input == "RECHAZAR"){
                //         if(soluciones.size != 0){
                //             println("Satisfacible cuando '" + args[2] + "' = '" + soluciones[0] + "'. Que desea hacer?")
                //             soluciones.removeAt(0)
                //         } else {
                //             println("No es satisfacible")
                //             break
                //         }
                //         input = readLine()!!
                //     }
                // }

            //Si ambos argumentos son variables
            } else {
                // var arg = Utilidades.args(argumentos, 1)
                // var args = arg.split(" ")
                // var soluciones = obtenerSoluciones3(args, lHechos)
                // if(soluciones.size != 0){
                //     println("Satisfacible cuando '"+args[1]+"' = '"+soluciones[0][1]+"' y '"+args[2]+"' = '"+soluciones[0][2]+"'. Que desea hacer?")
                //     soluciones.removeAt(0)
                    
                //     //Pido una respuesta a la primera solucion
                //     input = readLine()!!
                //     while(input == "RECHAZAR"){
                //         if(soluciones.size != 0){
                //             println("Satisfacible cuando '"+args[1]+"' = '"+soluciones[0][1]+"' y '"+args[2]+"' = '"+soluciones[0][2]+"'. Que desea hacer?")
                //             soluciones.removeAt(0)
                //         } else {
                //             println("No es satisfacible")
                //             break
                //         }
                //         input = readLine()!!
                //     }
                // }
            }
        } else if(argumentos[0] == "SALIR"){
            s = false
        } else {
            println("Entrada invalida.")
        }
    }
    
}
