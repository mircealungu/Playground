package lu.mir.jsst.helloworld;
import javassist.*;

/*
 * This class instruments the HelloWorld example by
 * adding a message to the sayIt() method 
 */
public class Instrument {

	public static void main(String[] args) {
		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass cc = pool.get("lu.mir.jsst.helloworld.HelloWorld");
			CtMethod m = cc.getDeclaredMethod("sayIt");
			m.insertBefore("System.out.println(\"Hello World!\");");
			cc.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HelloWorld hw = new HelloWorld();
		hw.sayIt();

	}

}

