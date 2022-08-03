package lib

object Utilidades{

    fun metodosPadres(clase: String, 
                      mapaClases: MutableMap<String, Int>, 
                      clases: MutableList<MutableList<String>>, 
                      jerarquia: MutableMap<String, String>,
                      metodos: MutableList<Pair<String, String>>) : MutableList<Pair<String, String>>{
        var lista = metodos
        var indice = mapaClases.getValue(clase)
        var status = true
        
        try{
            lista = metodos
            if(clases[indice].size == 3){
                for(i in 1..clases[indice].size-1){
                    for(j in 0..lista.size-1){
                        if(clases[indice][i] == lista[j].first){
                            status = false
                        }
                    }
                    if(status == false){
                        status = true
                        continue
                    }    
                    lista.add(Pair(clases[indice][i], clase))
                }
                return lista
            } else {
                for(i in 2..clases[indice].size-1){
                    lista.add(Pair(clases[indice][i], clase))
                }
                lista = metodosPadres(jerarquia.getValue(clase), mapaClases, clases, jerarquia, lista)
            }
            jerarquia.getValue(clase)
        } catch(error: NoSuchElementException){}        
        return lista
    }
}