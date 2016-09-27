package carton.javacompiler.io;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PathHandler {
	// Should be static
	private static File _startingLocation = new File("TestFiles");
	private File _fileToCompile;
	
	private String _folderToCompileTemplate = "1ToCompile";
	private String _folderExpectedTemplate = "2ExpectedResult";
	private String _folderResultTemplate = "3Result";
	
	private List<FileData> _listFileData = new ArrayList<FileData>();

	public PathHandler() {
		this(_startingLocation.getName());
	}
	
	public PathHandler(String fileToCompile) {
		_fileToCompile = findFileToCompile(fileToCompile, _startingLocation);
		buildListFileData(_fileToCompile);
	}
	
	// Find the File (directory or single file) to compile inside the standard main File (_startingLocation)
	// Returns the File which is then used to set the new main File (_fileToCompile)
	private File findFileToCompile(String fileName, File currentFile) {
		if(currentFile.getName().equals(fileName)) {
			return currentFile;
		}
		else {
			if(currentFile.isDirectory()) {
				for(File file : currentFile.listFiles()) {
					return findFileToCompile(fileName, file);
				}
			}
			return _startingLocation;
		}
	}

	// Fill the File ArrayList (_listFileData) with actual files (everything but actual directories) that need to be compiled
	private void buildListFileData(File curDir) {
		if(curDir.isDirectory()) {
			for(File directory : curDir.listFiles()) {
				if(directory.isDirectory()) { 
					if(!directory.getName().equals(_folderToCompileTemplate) && !directory.getName().equals(_folderExpectedTemplate) && !directory.getName().equals(_folderResultTemplate)) {
						buildListFileData(directory); 
					}
					else if(directory.getName().equals(_folderToCompileTemplate)) {
						for(File file : directory.listFiles()) {
							_listFileData.add(new FileData(file, file.getName(), Paths.get(file.getPath()), Paths.get(curDir.getPath() + "\\" + _folderResultTemplate + "\\" + file.getName())));
						}
					}
				}
			}
		}
		else {
			_listFileData.add(new FileData(curDir, curDir.getName(), Paths.get(curDir.getPath()), Paths.get(curDir.getPath() + "_compiled")));
		}
	}
	
	public List<FileData> 	get_listFileData() 								{ return _listFileData; }
	public void 			set_listFileData(List<FileData> listFileData) 	{ _listFileData = listFileData; }

	public File 			get_fileToCompile() 							{ return _fileToCompile; }
}
