
BCELDIR=lu/mir/bcel/classgen/

all: 
	echo "choose a target"

bcel:
	javac -cp lib/bcel-5.2/bcel-5.2.jar:. ${BCELDIR}/Generator.java
	java -cp lib/bcel-5.2/bcel-5.2.jar:. lu.mir.bcel.classgen.Generator
	mv HelloBCEL.class $(BCELDIR)
	(cd $(BCELDIR); echo "executing the generated code..."; java HelloBCEL)

clean:
	rm -rf $(BCELDIR)*.class
	rm -rf *.class