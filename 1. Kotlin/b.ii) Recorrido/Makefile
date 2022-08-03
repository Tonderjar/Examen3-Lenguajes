KC=		kotlinc
KFLAG=		-cp
LIBGRAPH=	Utils/
LIBJAR=		Utils/Utils.jar

all:	jarlib RecorridoKt.class

jarlib:
	(cd $(LIBGRAPH); make)  

RecorridoKt.class: Recorrido.kt 
	$(KC) $(KFLAG) $(LIBJAR) Recorrido.kt
clean:
	(cd $(LIBGRAPH); make clean)
	rm -rf *.class META-INF
