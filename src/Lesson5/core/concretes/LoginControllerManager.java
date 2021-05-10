package Lesson5.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Lesson5.core.abstracts.LoginControllerServices;

public class LoginControllerManager implements LoginControllerServices {

	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	public boolean isEMailValid(String eMailInput) {
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(eMailInput);
		
		boolean matchFound = matcher.find();
		
		if (!eMailInput.isEmpty() && matchFound) {
			return true;
		}
		else if (eMailInput.isEmpty()) {
			System.out.println("E-Posta adresini boş bırakamazsınız...");
			return false;
		}
		else {
			System.out.println("Geçerli bir e-posta adresi giriniz...");
			return false;
		}
		
	}

	public boolean isValidPassword(String password) {
		
		if (!password.isEmpty() && password.length() >= 6) {
			return true;
		}
		else if (password.isEmpty()) {
			System.out.println("Lütfen bir parola giriniz...");
			return false;
		}
		else {
			System.out.println("Parolanız en az 6 karakter olmalıdır...");
			return false;
		}
		
	}

	public boolean isValidFirstName(String firstName) {
		if (!firstName.isEmpty() && firstName.length() >= 2) {
			return true;
		}
		else {
			System.out.println("Adınız en az 2 karakter olmalıdır...");
			return false;
		}
		
	}

	public boolean isValidLastName(String lastName) {
		if (!lastName.isEmpty() && lastName.length() >= 2) {
			return true;
		}
		else {
			System.out.println("Soyadınız en az 2 karakter olmalıdır...");
			return false;
		}
		
	}

}
