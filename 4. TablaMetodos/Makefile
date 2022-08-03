KC=		kotlinc
KFLAG=		-cp
LIBGRAPH=	Utils/
LIBJAR=		Utils/Utils.jar

all:	jarlib TablaMetodosKt.class

jarlib:
	(cd $(LIBGRAPH); make)  

TablaMetodosKt.class: TablaMetodos.kt 
	$(KC) $(KFLAG) $(LIBJAR) TablaMetodos.kt
clean:
	(cd $(LIBGRAPH); make clean)
	rm -rf *.class META-INF
