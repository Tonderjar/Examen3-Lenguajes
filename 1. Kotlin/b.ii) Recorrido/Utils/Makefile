KC=	kotlinc
KFLAG=	-cp
GLIB=	lib

all:	Utils.jar

Utils.jar: $(GLIB)/Lado.class\
		$(GLIB)/Grafo.class\
		$(GLIB)/Secuencia.class\
		$(GLIB)/Pila.class\
		$(GLIB)/Cola.class\
		$(GLIB)/Busqueda.class\
		$(GLIB)/BFS.class\
		$(GLIB)/DFS.class

	jar -cvf $@ $(GLIB)/*.class 

$(GLIB)/Lado.class: $(GLIB)/Lado.kt
	$(KC) $(GLIB)/Lado.kt

$(GLIB)/Grafo.class: $(GLIB)/Grafo.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Grafo.kt


$(GLIB)/Secuencia.class: $(GLIB)/Secuencia.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Secuencia.kt
	
$(GLIB)/Pila.class: $(GLIB)/Pila.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Pila.kt

$(GLIB)/Cola.class: $(GLIB)/Cola.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Cola.kt

$(GLIB)/Busqueda.class: $(GLIB)/Busqueda.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Busqueda.kt

$(GLIB)/BFS.class: $(GLIB)/BFS.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/BFS.kt

$(GLIB)/DFS.class: $(GLIB)/DFS.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/DFS.kt

clean:
	rm -rf Utils.jar META-INF $(GLIB)/*.class
