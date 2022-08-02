KC=		kotlinc
KFLAG=		-cp
LIBGRAPH=	Utils/
LIBJAR=		Utils/Utils.jar

all:	jarlib SecuenciaKt.class

jarlib:
	(cd $(LIBGRAPH); make)  

SecuenciaKt.class: Secuencia.kt 
	$(KC) $(KFLAG) $(LIBJAR) Secuencia.kt
clean:
	(cd $(LIBGRAPH); make clean)
	rm -rf *.class META-INF
