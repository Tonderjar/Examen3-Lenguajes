package lib

object Utilidades{

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
        return 0
    }
    
}