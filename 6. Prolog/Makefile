KC=		kotlinc
KFLAG=		-cp
LIBGRAPH=	Utils/
LIBJAR=		Utils/Utils.jar

all:	jarlib PrologKt.class

jarlib:
	(cd $(LIBGRAPH); make)  

PrologKt.class: Prolog.kt 
	$(KC) $(KFLAG) $(LIBJAR) Prolog.kt
clean:
	(cd $(LIBGRAPH); make clean)
	rm -rf *.class META-INF
