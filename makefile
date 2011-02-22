# Copyright (c) Martin Ueding <dev@martin-ueding.de>

sierpinski2png.jar: Sierpinski.class
	jar -cfm sierpinski2png.jar manifest.txt *.class

Sierpinski.class: *.java
	javac Sierpinski.java
