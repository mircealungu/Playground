package lu.mir.bcel.classgen;

import org.apache.bcel.generic.*;
import org.apache.bcel.Constants;
import org.apache.bcel.classfile.JavaClass;
import java.io.IOException;

public class Generator {

	private static final String GENERATED_CLASS_NAME = "lu.mir.bcel.classgen.HelloBCEL";

	private static ClassGen cg;
	private static ConstantPoolGen cpg;
	private static MethodGen mg;

	// The instructions in the method
	private static InstructionList il;

	public static void main(String [] args) {
		System.out.println("Generating Class");

		ClassGen cg = new ClassGen ("HelloBCEL", "java.lang.Object", "HelloBCEL.java", Constants.ACC_PUBLIC, null);

		// Get a reference to the constant pool of the class
		cpg=cg.getConstantPool();

		// Add the instructions to the list
		il = new InstructionList(); 
		// 1. reference to the static out filed in java.lang.System
		il.append ( new GETSTATIC(cpg.addFieldref("java.lang.System", "out", "Ljava/io/PrintStream;")));
		// 2. push the constant to be printed on the stack
		il.append ( new LDC (cpg.addString("Hello BCEL!")));
		// 3. Invoke the print method
		il.append ( new INVOKEVIRTUAL(cpg.addMethodref("java.io.PrintStream", "println", "(Ljava/lang/String;)V")));
		// 4. return from the method
		il.append ( new RETURN());

		mg = new MethodGen ( 
					Constants.ACC_PUBLIC|Constants.ACC_STATIC, 
					Type.VOID, 
					new Type[]{new ArrayType(Type.STRING,1)}, 
					new String[]{"args"}, 
					"main",
					GENERATED_CLASS_NAME,
					il,
					cpg
					);

		mg.setMaxLocals();
		mg.setMaxStack();

		cg.addMethod(mg.getMethod());

		// Print out some stuff
		System.out.println(cpg.getFinalConstantPool());
		System.out.println(mg);
		System.out.println(il);

		JavaClass javaClass = cg.getJavaClass();
		try {
			// Write bytecode to file
			javaClass.dump("HelloBCEL.class");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}