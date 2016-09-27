package carton.javacompiler.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import carton.javacompiler.print.Printer;
import carton.javacompiler.tokenizer.Tokenizer;

public class ReaderWriter {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	private PathHandler _ph;
	private Tokenizer _tk;
	
	private List<FileData> _listFileData = new ArrayList<FileData>();
	private Printer printer = new Printer();
	private File _mainFile;
	
	public ReaderWriter(String fileToCompile) throws IOException {
		_ph = new PathHandler(fileToCompile);
		_mainFile = _ph.get_fileToCompile();
		_listFileData = _ph.get_listFileData();
		
		printer.printFileTree(_mainFile);
		
		readAllFiles();
		
		_tk = new Tokenizer(_listFileData);
		
		writeAllFiles();
		
		printer.printListFileData(_listFileData);
	}
	
	private void readAllFiles() throws IOException {
		for(FileData file : _listFileData) { readFile(file); }
	}
	private void readFile(FileData file) throws IOException {
		try(BufferedReader reader = Files.newBufferedReader(file.get_inputPath(), ENCODING)) {
			List<String> fileContent = new ArrayList<String>();
			String line = null;
			while((line = reader.readLine()) != null) {
				fileContent.add(line);
			}
			file.set_inputText(fileContent);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeAllFiles() throws IOException {
		for(FileData file : _listFileData) { writeFile(file); }
	}
	private void writeFile(FileData file) throws IOException {
		try(BufferedWriter writer = Files.newBufferedWriter(file.get_outputPath(), ENCODING)) {
			for(String line : file.get_outputText()) {
				writer.write(line);
				writer.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}