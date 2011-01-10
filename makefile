ampel.jar: Sierpinski.class
	jar -cfm ampel.jar manifest.txt *.class

Sierpinski.class: *.java
	javac Sierpinski.java
