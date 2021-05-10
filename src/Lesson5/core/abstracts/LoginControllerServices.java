package Lesson5.core.abstracts;

public interface LoginControllerServices {
	
	boolean isEMailValid(String eMailInput);
	boolean isValidPassword(String password);
	boolean isValidFirstName(String firstName);
	boolean isValidLastName(String lastName);
	
}
