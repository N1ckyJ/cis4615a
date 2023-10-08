
public class R02_XP00_J {
	//EXP00-J. Do not ignore values returned by methods
	//Noncompliant Code Example
	public void deleteFile(){
		File someFile = new File("someFileName.txt");
		// Do something with someFile
		someFile.delete();	 
	}

	//Compliant Code Example
	
	public void deleteFile(){
		File someFile = new File("someFileName.txt");
		// Do something with someFile
		if (!someFile.delete()) {
			// Handle failure to delete the file
		}
		 
	}


}
