import java.util.*;
public class CaesarCipher{


public static char[] alphabet;
public static String message;
public static String encrypted_message;
public static int shamt;

public CaesarCipher(){
alphabet = new char[26];
for(int i=65; i<91; i++)
{
	alphabet[i-65]=(char) i;
}

message="";
encrypted_message="";

}

public static void main(String args[])
{
	alphabet = new char[26];

for(int i=65; i<91; i++)
{
	alphabet[i-65]=(char) i;
}

message="";
encrypted_message="";

	Scanner in = new Scanner(System.in);
	System.out.println("Please enter your message.");
	message = in.nextLine();
	message = message.toUpperCase();
	System.out.println("Please enter your shift amount.");
	shamt = in.nextInt();
	while(shamt>=26)
		shamt-=26;
		encrypted_message = encrypt(shamt, message);

	System.out.println("Your encrypted message is " + encrypted_message);
	System.out.println("Your decrypted message is " + decrypt(shamt, encrypted_message));
	
	
	
	System.out.println("Please enter an encrypted message.");
	String mystery;
	in.nextLine();
	mystery = in.nextLine();
	mystery = mystery.toUpperCase();
	int shift = 0;
	String response = "";
	while(!response.equals("y"))
	{
		shift++;
		System.out.println(decrypt(shift, mystery));
		System.out.println("Is this a valid phrase? [Y/N]");
		response = in.nextLine();
		if(shift==26)
		{
			System.out.println("Answer not found.");
			return;
		}
	}
	System.out.println("Your shift amount was " + shift);	
}

public static String encrypt(int shamt, String m)
{
char[] cryptic_alphabet = new char[26];
char[] temp = new char[shamt];
String result = "";
int a=0;
int i=0;
for(i=alphabet.length-shamt; i<alphabet.length; i++)
{
	temp[a]=alphabet[i];
	a++;
}
for(i=0; i<shamt; i++)
{
	cryptic_alphabet[i]=temp[i];
	
}
for(i=0; i<alphabet.length-shamt; i++)
{
	cryptic_alphabet[i+shamt]=alphabet[i];
}
for(i=0; i<m.length(); i++)
{	
	if(m.charAt(i)==' ')
	{
		result=result+" ";
	}
	else
	{
		int value = (int)m.charAt(i);
		result = result + cryptic_alphabet[value-65];
	}
}
return result;



}
public static String decrypt(int s, String e)
{
	String result="";
for(int i=0; i<e.length(); i++)
{
	if(e.charAt(i)==' ')
	{
		result=result+ " ";
	}
	else{
		
	
	int value = (int) e.charAt(i);
	value = value-65+s;
	if(value>25)
	{
		value-=26;
	}
	result=result+alphabet[value];
	}
}
return result;
}
}