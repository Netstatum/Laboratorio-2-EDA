all: interfaz-grafica
	javac *.java


jar: all
	jar cfe ToxicDrop.jar Main *.class Grafica/src/Imagenes/*

#aqui utlizamos sed para sacar los packages y modifiar los directorios en
#los cuales se encuentran las imagenes ya que vamos a ejecutar fuera del 
#directorio original en el que fue programado
interfaz-grafica:
	mkdir -p Grafica/src/grafica/modificado
	cp Grafica/src/grafica/*.java Grafica/src/grafica/modificado
	sed -i 's/package\ grafica;/\ /g' Grafica/src/grafica/modificado/*.java
	sed -i 's/\/Imagenes/Grafica\/src\/Imagenes/g' Grafica/src/grafica/modificado/*.java
	javac Grafica/src/grafica/modificado/*.java
	cp Grafica/src/grafica/modificado/*.class ./

debug:
	javac -g *.java

jar-debug: debug
	jar cfe ToxicDrop.jar Main *.class Grafica/src/Imagenes/*

clear:
	rm *.class ToxicDrop.jar
	rm -r docs
doc:
	doxygen documentacion.cfg
