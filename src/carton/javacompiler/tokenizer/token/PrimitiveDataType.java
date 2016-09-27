package carton.javacompiler.tokenizer.token;

import java.util.Arrays;
import java.util.List;

public class PrimitiveDataType extends Token {
	protected String _tokenName;
	private static List<String> _types = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char");

	private PrimitiveDataType(String value) {
		super("PrimitiveDataType", value);
	}

	public static PrimitiveDataType getToken(char[] charArray, int indexCharArray) {
		String str = new String(charArray, 0, indexCharArray);
		return new PrimitiveDataType(str);
	}
	
	public static boolean isMatch(char[] charArray, int index) {
		return _types.contains(new String(charArray, 0, index));
	}
	
	
	
	
	
	
	
	
	
	
	
	public int PrimitiveDataTypeBuffer(String str, int index) {
		char c;
		do {
			c = str.charAt(index);
			if(Character.isLetter(c)) {
				Token.sb.append(c);
				index++;
			}
			else {
				String s = Token.sb.toString();
				/*if(isPrimitiveDataType(s)) {
					PrimitiveDataType.getToken(s);
					clearStringBuilder();
				}*/
			}
		} while(Character.isLetter(c));
		Token.clearStringBuilder();
		return index;
	}
}
