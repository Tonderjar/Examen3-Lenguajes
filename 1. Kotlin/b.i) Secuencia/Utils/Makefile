KC=	kotlinc
KFLAG=	-cp
GLIB=	lib

all:	Utils.jar

Utils.jar: $(GLIB)/Secuencia.class\
		$(GLIB)/Pila.class\
		$(GLIB)/Cola.class

	jar -cvf $@ $(GLIB)/*.class 

$(GLIB)/Secuencia.class: $(GLIB)/Secuencia.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Secuencia.kt

$(GLIB)/Pila.class: $(GLIB)/Pila.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Pila.kt

$(GLIB)/Cola.class: $(GLIB)/Cola.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Cola.kt


clean:
	rm -rf Utils.jar META-INF $(GLIB)/*.class
