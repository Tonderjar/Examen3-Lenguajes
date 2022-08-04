package lib

object Utilidades{


    fun args(argumentos: List<String>, ind: Int): String{
        var strAux1 = argumentos[ind]
        var strAux2 = argumentos[ind+1]
        strAux1 = strAux1.replace(",", "")
        strAux1 = strAux1.replace("(", " ")
        strAux2 = strAux2.replace(")", "")
        val strAux = strAux1 + " " + strAux2
        return strAux
    }

    fun tipoDef(args: List<String>) : Int {
        if(args.size == 1){
            return -1
        } else if(args.size == 3){
            if(args[1][0].isUpperCase()){
                return -1
            }
            if(args[2][args[2].length-1].compareTo(')') != 0){
                return -1
            }
            return 0
        } else if(args.size == 2){
            if(args[1][0].isUpperCase()){
                return -1
            }
            return 1
        } else{
            for(i in 0..((args.size-1)/2)-1){
                if(args[2*i+1][0].isUpperCase()){
                    return -1
                }
                if(args[2*i+2][args[2*i+2].length-1].compareTo(')') != 0){
                    return -1
                }
                if(args.size%2 == 0){
                    return -1
                }
            }
            return 2
        }
    }

    fun tipoAsk(args: List<String>) : Int {
        var argumentos = args(args, 1).split(" ")
        if(!argumentos[1][0].isUpperCase() && !argumentos[2][0].isUpperCase()){
            return 0
        } else {
            return 1
        }
    }

    fun obtenerSoluciones1(args: List<String>, 
                           lHechos: MutableList<List<String>>, 
                           lReglas: MutableList<List<String>>) : MutableList<String>{

        var soluciones = mutableListOf<String>()
        for(hecho in lHechos){
            if(hecho[0] == args[0]){    
                soluciones = fHechos(args, hecho, soluciones)
            }
        }
        for(regla in lReglas){
            var sol = mutableListOf<String>()
            if(regla[0] == args[0]){
                sol = fReglas1(args, args[2], lHechos, regla.size/3, regla, sol)
            }
            for(s in sol){
                if(!soluciones.contains(s)){
                    soluciones.add(s)
                }
            }
        }
        return soluciones
    }

    fun fHechos(args: List<String>, hecho: List<String>, soluciones: MutableList<String>) : MutableList<String>{
        var sol = soluciones
        if(hecho[2] == args[2]){
            if(!sol.contains(hecho[1])){
                sol.add(hecho[1])
            }
        }
        return soluciones
    }
 
    fun fReglas1(args: List<String>,
                 obj: String, 
                 lHechos: MutableList<List<String>>,  
                 ind: Int,
                 regla: List<String>,
                 solu: MutableList<String>) : MutableList<String>{
        
        if(ind > 1){
            var sol = mutableListOf<String>()
            for(hecho in lHechos){
                if(hecho[0] == regla[3*(ind-1)]){
                    sol = fHechos(listOf(regla[3*(ind-1)], regla[3*(ind-1)+1], obj), hecho, sol)
                }
            }
            if(ind < 3){
                return sol
            }
            var sol2 = mutableListOf<String>()
            for(elem in sol){
                sol2 = fReglas1(args, elem, lHechos, ind-1, regla, sol2)
                for(elem2 in sol2){
                    if(!solu.contains(elem2)){
                        solu.add(elem2)
                    }
                }
            }
            return solu
        } else{
            // var sol = mutableListOf<String>()
            // for(hecho in lHechos){
            //     if(hecho[0] == regla[3*(ind-1)]){    
            //         sol = fHechos(listOf(regla[3*(ind-1)], regla[3*(ind-1)+1], obj), hecho, sol)
            //     }
            // }
            // for(elem in sol){
            //     if(!sol.contains(elem)){
            //         solu.add(elem)
            //     }
            // }
            return solu
        }
        //sol = fHechos(listOf(args[3*(ind-1)], args[3*(ind-1)+1], args[3*(ind-1)+2]), lHechos)
    }
    
}