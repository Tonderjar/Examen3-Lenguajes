KC=	kotlinc
KFLAG=	-cp
GLIB=	lib

all:	Utils.jar

Utils.jar: $(GLIB)/Utilidades.class

	jar -cvf $@ $(GLIB)/*.class 

$(GLIB)/Utilidades.class: $(GLIB)/Utilidades.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Utilidades.kt

clean:
	rm -rf Utils.jar META-INF $(GLIB)/*.class
