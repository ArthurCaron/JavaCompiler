package carton.javacompiler.tokenizer.token;

import java.util.Arrays;
import java.util.List;

public class Separator extends Token {
	protected String _tokenName;
	private static List<String> _types = Arrays.asList(
				new String(" "), new String(";"), new String("\t"), new String("\n"), new String("\r"),
				new String("("), new String(")"), new String("["), new String("]"), new String("."),
				new String("+"), new String("-"), new String("*"), new String("/"), new String("%"),
				new String("="), new String("<"), new String(">"), new String("!"), new String("~"),
				new String("&"), new String("|"), new String("^"),
				new String("?"), new String(":"),
				new String("/"), new String("\\")
			);

	private Separator(String value) {
		super("Separator", value);
	}
	
	public static Separator getToken(char c) {
		return new Separator(Character.toString(c));
	}
	
	public static boolean isMatch(char c) {
		return _types.contains(Character.toString(c));
	}
}