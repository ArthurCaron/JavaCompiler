package carton.javacompiler.tokenizer.token;

public abstract class Token {
	protected String _tokenName = "Token";
	protected String _value;
	
	protected Token(String tokenName, String value) {
		_tokenName = tokenName;
		_value = value;
	}
	
	
	
	public static StringBuilder sb = new StringBuilder(); // ERF
	public static void clearStringBuilder() {
		sb.setLength(0);
	}
	
	
	
	
	public String toString() {
		return _value;
	}
	
	public String toStringTreeLight() {
		return "[" + _value + "]";
	}
	
	public String toStringTree() {
		return "[" + _tokenName + " : '" + _value + "']";
	}
	
	public String get_value() { return _value; }
	public void set_value(String value) { _value = value; }
}

/*
isLowerCase
isUpperCase
isDigit
isDefined
isLetter
isLetterOrDigit
isAlphabetic
isJavaIdentifierStart
isJavaIdentifierPart
isIdentifierIgnorable
isSpaceChar
isWhitespace





isLetter()
Determines whether the specified char value is a letter.

isDigit()
Determines whether the specified char value is a digit.

isWhitespace()
Determines whether the specified char value is white space.

isUpperCase()
Determines whether the specified char value is uppercase.

isLowerCase()
Determines whether the specified char value is lowercase.

toUpperCase()
Returns the uppercase form of the specified char value.

toLowerCase()
Returns the lowercase form of the specified char value.

toString()
Returns a String object representing the specified character valuethat is, a one-character string.











isLowerCase
public static boolean isLowerCase(char ch)

Determines if the specified character is a lowercase character. 
A character is lowercase if its general category type, provided by Character.getType(ch), is LOWERCASE_LETTER, or it has contributory property Other_Lowercase as defined by the Unicode Standard. 

The following are examples of lowercase characters: 

 a b c d e f g h i j k l m n o p q r s t u v w x y z


 
 isUpperCase
 public static boolean isUpperCase(char ch)

 Determines if the specified character is an uppercase character. 
 A character is uppercase if its general category type, provided by Character.getType(ch), is UPPERCASE_LETTER. or it has contributory property Other_Uppercase as defined by the Unicode Standard. 

 The following are examples of uppercase characters: 

  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z


  
  isDigit
  public static boolean isDigit(char ch)

  Determines if the specified character is a digit. 
  A character is a digit if its general category type, provided by Character.getType(ch), is DECIMAL_DIGIT_NUMBER. 

  Some Unicode character ranges that contain digits: 
  •'\u0030' through '\u0039', ISO-LATIN-1 digits ('0' through '9') 

  
  
  isDefined
  public static boolean isDefined(char ch)

  Determines if a character is defined in Unicode. 
  A character is defined if at least one of the following is true: 
  •It has an entry in the UnicodeData file. 
  •It has a value in a range defined by the UnicodeData file. 

  
  
  isLetter
  public static boolean isLetter(char ch)

  Determines if the specified character is a letter. 
  A character is considered to be a letter if its general category type, provided by Character.getType(ch), is any of the following: 
  • UPPERCASE_LETTER 
  • LOWERCASE_LETTER 
  • TITLECASE_LETTER 
  • MODIFIER_LETTER 
  • OTHER_LETTER 
  Not all letters have case. Many characters are letters but are neither uppercase nor lowercase nor titlecase. 
  
  
  isLetterOrDigit
  public static boolean isLetterOrDigit(char ch)

  Determines if the specified character is a letter or digit. 
  A character is considered to be a letter or digit if either Character.isLetter(char ch) or Character.isDigit(char ch) returns true for the character. 

  
  
  isAlphabetic
public static boolean isAlphabetic(int codePoint)

Determines if the specified character (Unicode code point) is an alphabet. 
A character is considered to be alphabetic if its general category type, provided by getType(codePoint), is any of the following: 
• UPPERCASE_LETTER 
• LOWERCASE_LETTER 
• TITLECASE_LETTER 
• MODIFIER_LETTER 
• OTHER_LETTER 
• LETTER_NUMBER 
or it has contributory property Other_Alphabetic as defined by the Unicode Standard.



isJavaIdentifierStart
public static boolean isJavaIdentifierStart(char ch)

Determines if the specified character is permissible as the first character in a Java identifier. 
A character may start a Java identifier if and only if one of the following conditions is true: 
• isLetter(ch) returns true 
• getType(ch) returns LETTER_NUMBER 
• ch is a currency symbol (such as '$') 
• ch is a connecting punctuation character (such as '_'). 





isJavaIdentifierPart
public static boolean isJavaIdentifierPart(char ch)

Determines if the specified character may be part of a Java identifier as other than the first character. 
A character may be part of a Java identifier if any of the following are true: 
• it is a letter 
• it is a currency symbol (such as '$') 
• it is a connecting punctuation character (such as '_') 
• it is a digit 
• it is a numeric letter (such as a Roman numeral character) 
• it is a combining mark 
• it is a non-spacing mark 
• isIdentifierIgnorable returns true for the character 





isIdentifierIgnorable
public static boolean isIdentifierIgnorable(char ch)

Determines if the specified character should be regarded as an ignorable character in a Java identifier or a Unicode identifier. 
The following Unicode characters are ignorable in a Java identifier or a Unicode identifier: 
•ISO control characters that are not whitespace •'\u0000' through '\u0008' 
•'\u000E' through '\u001B' 
•'\u007F' through '\u009F' 

•all characters that have the FORMAT general category value 





isSpaceChar
public static boolean isSpaceChar(char ch)

Determines if the specified character is a Unicode space character. A character is considered to be a space character if and only if it is specified to be a space character by the Unicode Standard. This method returns true if the character's general category type is any of the following: 
• SPACE_SEPARATOR 
• LINE_SEPARATOR 
• PARAGRAPH_SEPARATOR 



isWhitespace
public static boolean isWhitespace(char ch)

Determines if the specified character is white space according to Java. A character is a Java whitespace character if and only if it satisfies one of the following criteria: 
• It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, or PARAGRAPH_SEPARATOR) but is not also a non-breaking space ('\u00A0', '\u2007', '\u202F'). 
• It is '\t', U+0009 HORIZONTAL TABULATION. 
• It is '\n', U+000A LINE FEED. 
• It is '\u000B', U+000B VERTICAL TABULATION. 
• It is '\f', U+000C FORM FEED. 
• It is '\r', U+000D CARRIAGE RETURN. 
• It is '\u001C', U+001C FILE SEPARATOR. 
• It is '\u001D', U+001D GROUP SEPARATOR. 
• It is '\u001E', U+001E RECORD SEPARATOR. 
• It is '\u001F', U+001F UNIT SEPARATOR. 







 */
  