all:
	javac *.java


jar: all
	jar cfe trinity.jar trinity *.class

debug:
	javac -g *.java

jar-debug: debug
	 jar cfe trinity.jar trinity *.class

clear:
	rm *.class trinity.jar trinity-manpage.pdf
