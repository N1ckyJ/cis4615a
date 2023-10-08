
public class R04_STR03_J {
	// STR03-J. Do not encode noncharacter data as a string 
	//Noncompliant Code Example
	BigInteger x = new BigInteger("530500452766");
	byte[] byteArray = x.toByteArray();
	String s = new String(byteArray);
	byteArray = s.getBytes();
	x = new BigInteger(byteArray);
	
	//Compliant Code Example
	BigInteger x = new BigInteger("530500452766");
	String s = x.toString();  // Valid character data
	byte[] byteArray = s.getBytes();
	String ns = new String(byteArray); 
	x = new BigInteger(ns); 

}
