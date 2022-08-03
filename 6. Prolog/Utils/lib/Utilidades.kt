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
        return 1
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
            if(regla[0] == args[0]){
                var sol = mutableListOf<String>()
                sol = fReglas1(args, lHechos, 1, regla, sol)
            }
            for(solu in sol){
                if(!soluciones.contains(solu)){
                    soluciones.add(solu)
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
                 lHechos: MutableList<List<String>>,  
                 ind: Int,
                 regla: List<String>,
                 solu: MutableList<String>) : MutableList<String>{

        var sol = mutableListOf<String>()
        if(ind == regla.size/3){
            for(hecho in lHechos){
                if(hecho[0] == args[3*(ind-1)]){    
                    solu = fHechos(listOf(args[args.size-3], args[args.size-2], args[args.size-1]), hecho, sol)
                }
            }
            return solu
        } else{
            if(solu.size == 0){
                return solu
            }
            for(elem in solu){

            }
        }

        //sol = fHechos(listOf(args[3*(ind-1)], args[3*(ind-1)+1], args[3*(ind-1)+2]), lHechos)
    }
    
}