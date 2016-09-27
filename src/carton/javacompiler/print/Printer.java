package carton.javacompiler.print;

import java.io.File;
import java.util.List;

import carton.javacompiler.io.FileData;

public class Printer {
	private StringBuilder _sb = new StringBuilder();

	// Print the File Tree contained in the main directory (_fileToCompile) (files and directories)
	public void printFileTree(File file) {
		directoryTree(_sb, file, 0);
		System.out.println(_sb.toString());
		clearStringBuilder();
	}
	
	// Calls appendFile on the Files contained in the main directory (
	private void directoryTree(StringBuilder sb, File current, int depth) {
		for(int i = 0; i < depth; i++) { sb.append("  "); }
		appendFile(sb, current);
		if(current.isDirectory()) {
			for(File file : current.listFiles()) {
				directoryTree(sb, file, depth + 1);
			}
		}
	}
	
	// Append the File to the StringBuilder
	private void appendFile(StringBuilder sb, File file) {
		if(file.isDirectory()) {
			sb.append("> " + file.getName() + " [Directory] " + System.lineSeparator());
		}
		else {
			sb.append("- " + file.getName() + " [File] " + System.lineSeparator());
		}
	}
	
	
	
	// Print the data gathered in buildListFileData (actual files, no directories, that need to be compiled)
	public void printListFileData(List<FileData> listFileData) {
		for(FileData fileData : listFileData) {
			fileData.toString(_sb);
		}
		System.out.println(_sb.toString());
		clearStringBuilder();
	}
	
	
	
	private void clearStringBuilder() {
		_sb.setLength(0);
	}
}
