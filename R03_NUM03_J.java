
public class R03_NUM03_J {
	 //NUM03-J. Use integer types that can fully represent the possible range of unsigned data 
	 //Noncompliant Code Example
	public static int getInteger(DataInputStream is) throws IOException {
		return is.readInt(); 
	}
	
	 //Compliant Code Example
	
	public static long getInteger(DataInputStream is) throws IOException {
		return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
	}


}
