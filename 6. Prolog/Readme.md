# Secuencia

##  Para compilar:

    Para compilar solo debe dirigirse al directorio "/6. Prolog" donde encontrara el shell script para la ejecucion del programa. Una vez en dicho directorio, correr el comando "make" compilara todos los archivos necesarios.

## Para ejecutar:

    Para ejecutar solo debe correr el comando "./runProlog.sh" en Linux. El programa es interactivo, por lo que la corrida dependera de los datos que se utilicen mientras se corre.

## Notas:

    Funciona para todas las definiciones, las consultas de tipo padre(pedro, juan), donde retornara true si el hecho esta cargado anteriormente o false si no, tambien funciona para reglas cuya definicion utilice un solo predicado, por ejemplo, ancestro(X, Y) padre(X, Y);
    donde si se pregunta ancestro(X, y) y existe una definicion para padre(x, y), el programa encontrara a la x. No se pudo resolver la recursion a tiempo para un funcionamiento completo.