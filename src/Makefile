all:
	javac *.java


jar: all
	jar cfe ToxicDrop.jar ToxicDrop *.class

debug:
	javac -g *.java

jar-debug: debug
	 jar cfe ToxicDrop.jar ToxicDrop *.class

clear:
	rm *.class ToxicDrop.jar
	rm -r docs
doc:
	doxygen documentacion.cfg
