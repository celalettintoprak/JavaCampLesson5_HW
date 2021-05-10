package Lesson5.core.concretes;

import Lesson5.core.abstracts.EMailValidationServices;
import Lesson5.entities.concretes.User;

public class EMailValidationManager implements EMailValidationServices {

	public void sendValidationEmailForUser(User user) {
		
		System.out.println(user.getEMail() + " e-posta adresinize doğrulama linki gönderildi.");
		System.out.println("Doğrulama linkini tıklayarak hesabınızı aktifleştirebilirsiniz..." + "\n");
	}

}
