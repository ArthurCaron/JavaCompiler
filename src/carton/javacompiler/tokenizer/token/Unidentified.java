package carton.javacompiler.tokenizer.token;

public class Unidentified extends Token {
	protected String _tokenName;

	private Unidentified(String value) {
		super("Unidentified", value);
	}
	
	public static Unidentified getToken(char[] charArray, int indexCharArray) {
		String str = new String(charArray, 0, indexCharArray);
		return new Unidentified(str);
	}
}
