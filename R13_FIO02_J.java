
public class R13_FIO02_J {
	//FIO02-J. Detect and handle file-related errors 	
	//Noncompliant Code Example
	File file = new File(args[0]);
	file.delete();
	//Compliant Code Example
	File file = new File("file");
	if (!file.delete()) {
	  // Deletion failed, handle error
	}


}
