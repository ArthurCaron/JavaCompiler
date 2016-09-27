package carton.javacompiler.main;

import java.io.IOException;

import carton.javacompiler.io.ReaderWriter;

public class Main {

	private final static String FILE_TO_COMPILE = "1SimpleDeclaration";
	private final static String DIRECTORY_TO_COMPILE = "1PrimitiveTypes";
	
	public static void main(String[] args) throws IOException {
		ReaderWriter rw = new ReaderWriter(DIRECTORY_TO_COMPILE);
	}
}
