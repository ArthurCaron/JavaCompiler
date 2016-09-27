package carton.javacompiler.tocompile;

public class CurrentFileToCompile {
	
public void simpleDeclaration() {
byte temperature;
short vitesseMax;
int temperatureSoleil;
long anneeLumiere;
float pi;
float nombre;
double division;
char caractere;
boolean question;
}

public void declarationWithInit() {
byte temperature = 64;
short vitesseMax = 32000;
int temperatureSoleil = 15600000;
long anneeLumiere = 9460700000000000L;
float pi = 3.141592653f;
float nombre = 2.0f;
double division = 0.333333333333333333333333333333333333333333334d;
char caractere = 'A';
boolean question = true;
}

public void declarationFollowedByInit() {
byte temperature;
short vitesseMax;
int temperatureSoleil;
long anneeLumiere;
float pi;
float nombre;
double division;
char caractere;
boolean question;

temperature = 64;
vitesseMax = 32000;
temperatureSoleil = 15600000;
anneeLumiere = 9460700000000000L;
pi = 3.141592653f;
nombre = 2.0f;
division = 0.333333333333333333333333333333333333333333334d;
caractere = 'A';
question = true;
}

public void initOfObjects() {
//Première méthode de déclaration
String phrase;
phrase = "Titi et Grosminet";

//Deuxième méthode de déclaration
String str = new String();
str = "Une autre chaîne de caractères";

//Troisième méthode de déclaration
String string = "Une autre chaîne";

//Quatrième méthode de déclaration
String chaine = new String("Et une de plus !");
}

public void declarationOfMultipleVarOnTheSameLine() {
int nbre1, nbre2, nbre3;
int nbre4 = 2, nbre5, nbre6 = 0;
}

public void simpleMaths() {
int n1, n2, n3;

n1 = 1 + 2;
n1 = 1+ 2;
n1 = 1 +2;
n1 = 1+2;
n1 = 2 - 1;
n1 = 2 * 2;
n1 = 2 / 2;
n1 = 10 % 3;

n2 = (1+2)/ (3  -(6   *4));

n1 = 2;
n2 = 3;
n3 = n1 * n2;
n3 = n3 + 2;
n3 = n1 + n3;

n3++;
n3--;
++n3;
--n3;

n1 = n2 = n3 = 0;

n1 += 2;
n1 -= 1;
n1 *= 100;
n1 /= 10;
n1 %= 3;
}



/*public void toCompile() {
	
	
double nbre1 = 10, nbre2 = 3;
int resultat = (int)(nbre1 / nbre2);
System.out.println("Le résultat est = " + resultat);

int resultat = (int)(nbre1 / nbre2);

int resultat = nbre1 / nbre2;

int i = 123;
float j = (float)i;

int i = 123;
double j = (double)i;

double i = 1.23;
double j = 2.9999999;
int k = (int)i;        //k vaut 1
k = (int)j;            //k vaut 2

double nbre1 = 10, nbre2 = 3;
int resultat = (int)(nbre1 / nbre2);
System.out.println("Le résultat est = " + resultat);

int nbre1 = 3, nbre2 = 2;
double resultat = nbre1 / nbre2;
System.out.println("Le résultat est = " + resultat);

int nbre1 = 3, nbre2 = 2;
double resultat = (double)(nbre1 / nbre2);
System.out.println("Le résultat est = " + resultat);

int nbre1 = 3, nbre2 = 2;
double resultat = (double)(nbre1) / (double)(nbre2);
System.out.println("Le résultat est = " + resultat); 
//affiche : Le résultat est = 1.5

int i = 12;
String j = new String();
j = j.valueOf(i);

int i = 12;
String j = new String();
j = j.valueOf(i);
int k = Integer.valueOf(j).intValue();

double nombre = 1000000000000d; // cast en d
//Peut s'écrire ainsi
double nombre = 1____000____000___000_000d; // cast en d
//Le nombre d'underscore n'a pas d'importance

//Voici quelques autres exemple d'utilisation
int entier = 32_000;
double monDouble = 12_34_56_78_89_10d; // cast en d
double monDouble2 = 1234_5678_8910d;   // cast en d

double d = 123_.159;
int entier = _123;
int entier2 = 123_;

int entier = 255; //Peut s'écrire « int entier = 0xFF; »
int entier = 20; //Peut s'écrire « int entier = 0x14; »
int entier = 5112; //Peut s'écrire « int entier = 0x13_F8; »

int entier = 0b1111_1111; //Est équivalent à : « int entier = 255; »
int entier = 0b1000_0000_0000; //Est équivalent à : « int entier = 2048; »
int entier = 0b100000000000; //Est équivalent à : « int entier = 2048; »
}*/
}
