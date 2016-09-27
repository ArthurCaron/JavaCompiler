package carton.javacompiler.io;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileData {
	private File _file;
	private String _fileName;
	private Path _inputPath;
	private Path _outputPath;
	
	private List<String> _inputText;
	private List<String> _outputText;
	
	public FileData(File file, String fileName, Path from, Path to) {
		_file = file;
		_fileName = fileName;
		_inputPath = from;
		_outputPath = to;
		_inputText = new ArrayList<String>();
		_outputText = new ArrayList<String>();
	}
	
	public String toString() {
		StringBuilder _sb = new StringBuilder();
		this.toString(_sb);
		return _sb.toString();
	}
	
	public void toString(StringBuilder sb) {
		sb.append("> " + _fileName + " <" 
						+ System.lineSeparator() + "from: " + _inputPath 
						+ System.lineSeparator() + "to:   " + _outputPath 
						+ System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append("InputText: ");
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		for(String str : _inputText) {
			sb.append(str + System.lineSeparator());
		}
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append("OutputText: ");
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		for(String str : _outputText) {
			sb.append(str + System.lineSeparator());
		}
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
	}

	public File get_file() { return _file; }
	public void set_file(File file) { _file = file; }

	public String get_fileName() { return _fileName; }
	public void set_fileName(String fileName) { _fileName = fileName; }

	public Path get_inputPath() { return _inputPath; }
	public void set_inputPath(Path inputPath) { _inputPath = inputPath; }

	public Path get_outputPath() { return _outputPath; }
	public void set_outputPath(Path outputPath) { _outputPath = outputPath; }

	public List<String> get_inputText() { return _inputText; }
	public void set_inputText(List<String> inputText) { _inputText = inputText; }

	public List<String> get_outputText() { return _outputText; }
	public void set_outputText(List<String> outputText) { _outputText = outputText; }
	public void addOutputLine(String outputLine) { _outputText.add(outputLine); }
	public void addOutputText(List<String> outputText) { _outputText.addAll(outputText); }
}
