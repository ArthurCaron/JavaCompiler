package carton.javacompiler.tokenizer;

import java.util.ArrayList;
import java.util.List;

import carton.javacompiler.io.FileData;
import carton.javacompiler.tokenizer.token.PrimitiveDataType;
import carton.javacompiler.tokenizer.token.Separator;
import carton.javacompiler.tokenizer.token.Token;
import carton.javacompiler.tokenizer.token.Unidentified;

public class Tokenizer {
	/*
	A ne pas oublier :
	Faire une liste de String (ou de Command ?) représentant les différents token possible actuellement
	Les différents "Character.isWhitespace", "Character.isLetter", etc remplissent cette liste de String
	On doit avoir un lookahead de 1
	Si le prochain char invalide un possible Token 
		(par ex le chiffre 1 alors qu'on a une liste de char invalide le PrimitiveDataType)
		alors on lance une méthode qui parcourre la liste de Command possible et appelle les "isMatch" des Tokens
		sauf que dans cet exemple le identifierToken est toujours possible et donc on ne doit pas appeler
		le "isMatch" mais simplement enlever de la liste des possibilités le "PrimitiveDataType"
		de la même manière, si on prédétermine que les "PDT" ne peuvent pas faire plus de 6 char, alors on peut
		les invalider à partir du 7eme
	*/
	
	/*
	List de séparateurs (espace, +, -, etc)
	Je lis jusqu'au premier séparateur
	Je teste le mot obtenu contre tous les différents types de token
	
	Calcul static de la taille max des valeurs de Token (par ex : PDT max char is 7)
	Je crée un tableau static avec [id][taille max][type de token] trié par taille max (plus petit en premier)
	On parcourt le tableau jusqu'à ce que la taille du mot obtenu soit inférieur à [taille max]
	On teste contre tous les différents types de token qui sont dans la suite du tableau
	
	pour plus tard :
	ajouter quelque règles de grammaire pour prioriser comme :
		après un "int" on doit avoir un "IdentifierToken"
		
	
	
	
	
	
	
	*/
	
	// Maybe full static ?
	private List<FileData> _listFileData = new ArrayList<FileData>();
	private List<Token> _listToken = new ArrayList<Token>();
	
	public Tokenizer(List<FileData> listFileData) {
		_listFileData = listFileData;
		fileBuffer();
	}
	
	private void fileBuffer() {
		for(FileData file : _listFileData) {
			for(String str : file.get_inputText()) {
				lineBuffer(str);
				file.addOutputLine(treeWriterLight());
			}
		}
	}
	
	private void lineBuffer(String str) {
		char[] charArray = new char[str.length()];
		char c;

		for(int indexString = 0, indexCharArray = 0; indexString < str.length(); indexString++, indexCharArray++) {
			c = str.charAt(indexString);
			if(Separator.isMatch(c)) {
				if(indexCharArray > 0) {
					// search token according to charArray and indexCharArray
					if(PrimitiveDataType.isMatch(charArray, indexCharArray)) {
						_listToken.add(PrimitiveDataType.getToken(charArray, indexCharArray));
					}
					else {
						_listToken.add(Unidentified.getToken(charArray, indexCharArray));
					}
					// instead of this ^
				}
				indexCharArray = -1;
				_listToken.add(Separator.getToken(c));
			}
			else {
				charArray[indexCharArray] = c;
			}
		}
	}
	
	private String lineWriter() {
		for(Token t : _listToken) {
			Token.sb.append(t.toString());
		}
		String s = Token.sb.toString();
		Token.clearStringBuilder();
		_listToken.clear();
		return s;
	}
	
	private String treeWriterLight() {
		for(Token t : _listToken) {
			Token.sb.append(t.toStringTreeLight());
		}
		String s = Token.sb.toString();
		Token.clearStringBuilder();
		_listToken.clear();
		return s;
	}
	
	private String treeWriter() {
		for(Token t : _listToken) {
			Token.sb.append(t.toStringTree());
		}
		String s = Token.sb.toString();
		Token.clearStringBuilder();
		_listToken.clear();
		return s;
	}
	
	/* Old - is it still relevant?
	private void lineBuffer(String str) {
		char[] charArray = new char[str.length()];
		boolean tokenFound = true;
		
		boolean pm_PrimitiveDataType = false;
		
		for(int indexString = 1, indexCharArray = 0; indexString < str.length(); indexString++, indexCharArray++) {
			if(tokenFound) {
				indexCharArray = 0;
				charArray[indexCharArray] = str.charAt(indexString - 1);
				pm_PrimitiveDataType = false;
			}
			charArray[indexCharArray + 1] = str.charAt(indexString);
			
			
			
			// ENUM PrimitiveDataType = 1, Identifier = 2, etc
			// TAB[11]
			// TAB[PrimitiveDataType] = TAB[1] = COMMAND.getToken() [primitiveDataType.getToken]
			// TAB[identifier] = null;
			
			
			
			
			/*if(Character.isWhitespace(charArray[i])) {
				UnidentifiedToken.getToken(charArray[i]);
			}
			else *//*if(Character.isLetter(charArray[indexCharArray])) {
				pm_PrimitiveDataType = true;
			}
			else {
				if(pm_PrimitiveDataType) { 
					pm_PrimitiveDataType = PrimitiveDataType.isMatch(charArray, indexCharArray);
					if(pm_PrimitiveDataType) {
						//PrimitiveDataType.getToken(charArray, indexCharArray);// PrimitiveDataTypeBuffer(str, i);
						tokenFound = true;
					}
				}
				//UnidentifiedToken.getToken(charArray[indexCharArray]);
				tokenFound = true;
			}
			
		}
	}
	*/
}








/*

DataType :
	PrimitiveDataType : byte, short, int, long, float, double, boolean, char
	ReferenceDataType : see later


Loop : 
	LoopType : while, for, do...while, foreach, 
	LoopControlStatement : break, continue


Statement : if, else if, else, switch(case, break, default), ? : (ternary)
	

Identifier : nom de variable, méthode, etc
    All identifiers should begin with a letter (A to Z or a to z), currency character ($) or an underscore (_).
    After the first character identifiers can have any combination of characters.
    A key word cannot be used as an identifier.
    Most importantly identifiers are case sensitive.
    Examples of legal identifiers: age, $salary, _value, __1_value
    Examples of illegal identifiers: 123abc, -salary
	Un nom de variable ou de constante est contitué de lettres, de chiffres de '_', et de symboles monétaires ('$', '£', '€', etc... ) 
	et ne peut pas commencer par un chiffre. Plus généralement la méthode Character.isJavaIdentifierStart(Char c) retourne true si c peut commencer un identificateur, 
	et la méthode Character.isJavaIdentifierPart(Char c) retourne true si c peut faire partie du reste de l'identificateur.
	Cannot be : abstract, continue, for, new, switch, assert 	default 	goto 	package 	synchronized
	boolean 	do 	if 	private 	this
	break 	double 	implements 	protected 	throw
	byte 	else 	import 	public 	throws
	case 	enum 	instanceof 	return 	transient
	catch 	extends 	int 	short 	try
	char 	final 	interface 	static 	void
	class 	finally 	long 	strictfp 	volatile
	const 	float 	native 	super 	while


Operator :
    Arithmetic Operators	: +, -, *, /, %, ++, --
    Relational Operators	: ==, !=, >, <, >=, <=
    Bitwise Operators		: &, |, ^, ~, <<, >>, >>>
    Logical Operators		: &&, ||, !
	Assignment Operators	: =, +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, |=
	Misc Operators			: ? : (ternary), instanceof  
	
	Category  			Operator  							Associativity 
	Postfix  			() [] . (dot operator) 				Left  to right 
	Unary  				++ -- + - ! ~ 						Right to left 
	Multiplicative   	* / %  								Left  to right 
	Additive   			+ -  								Left  to right 
	Shift   			>> >>> <<   						Left  to right 
	Relational   		> >= < <=   						Left  to right 
	Equality   			== !=  								Left  to right 
	Bitwise AND  		&  									Left  to right 
	Bitwise XOR  		^  									Left  to right 
	Bitwise OR  		|  									Left  to right 
	Logical AND  		&&  								Left  to right 
	Logical OR  		||  								Left  to right 
	Conditional  		?:  								Right to left 
	Assignment  		= += -= *= /= %= >>= <<= &= ^= |=  	Right to left 
	Misc				instanceof							Left  to right


Modifier :
    Access Modifiers: (default), public, protected, private
    Non-access Modifiers: static, final, abstract, synchronized, volatile



NonSupportedKeyword : abstract, continue, for, new, switch, assert 	default 	goto 	package 	synchronized  boolean 	do 	if 	private 	this break 	double 	implements 	protected 	throw byte 	else 	import 	public 	throws case 	enum 	instanceof 	return 	transient catch 	extends 	int 	short 	try char 	final 	interface 	static 	void class 	finally 	long 	strictfp 	volatile const 	float 	native 	super 	while

Comment : // ... \n ou /* ... (\n) ... */ /*












Good to know :
	\n 	Newline (0x0a)
	\r 	Carriage return (0x0d)
	\f 	Formfeed (0x0c)
	\b 	Backspace (0x08)
	\s 	Space (0x20)
	\t 	tab
	\" 	Double quote
	\' 	Single quote
	\\ 	backslash
	\ddd 	Octal character (ddd)
	\ uxxxx 	Hexadecimal UNICODE character (xxxx)


*/