echo Compiling...
javac -cp ../../../../lib/javassist.jar:. HelloWorld.java Instrument.java 
echo Executing...
(cd ../../../.. && java -cp lib/javassist.jar:. lu.mir.jsst.hw.Instrument)

