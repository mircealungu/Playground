package lu.mir.jsst.hw;
import javassist.*;

public class Instrument {

	public static void main(String[] args) {
		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass cc = pool.get("lu.mir.jsst.hw.HelloWorld");
			CtMethod m = cc.getDeclaredMethod("sayIt");
			m.insertBefore("System.out.println(\"Hello World\");");
			cc.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		HelloWorld hw = new HelloWorld();
		hw.sayIt();

	}

}

