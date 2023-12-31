
public class R00_IDS03_J {
	//IDS03-J. Do not log unsanitized user input
	//Noncompliant Code Example
	
	if (loginSuccessful) {
		  logger.severe("User login succeeded for: " + username);
		} else {
		  logger.severe("User login failed for: " + username);
		}
	//Compliant Code Example
	if (loginSuccessful) {
		  logger.severe("User login succeeded for: " + sanitizeUser(username));
		} else {
		  logger.severe("User login failed for: " + sanitizeUser(username));
		}

	public String sanitizeUser(String username) {
		return Pattern.matches("[A-Za-z0-9_]+", username)) ? username : "unauthorized user";
	}
}
