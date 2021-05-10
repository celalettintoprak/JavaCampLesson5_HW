package Lesson5.business.concretes;

import Lesson5.business.abstracts.UserService;
import Lesson5.core.abstracts.EMailValidationServices;
import Lesson5.core.abstracts.JExternalServices;
import Lesson5.core.abstracts.LoginControllerServices;
import Lesson5.dataAccess.abstracts.UserDao;
import Lesson5.entities.concretes.User;

public class UserManager implements UserService {
	
	private LoginControllerServices loginControllerServices;
	private UserDao userDao;
	private EMailValidationServices eMailValidationServices;
	private JExternalServices jExternalServices;
	
	public UserManager(LoginControllerServices loginControllerServices, UserDao userDao,
			EMailValidationServices eMailValidationServices, JExternalServices jExternalServices) {
		this.loginControllerServices = loginControllerServices;
		this.userDao = userDao;
		this.eMailValidationServices = eMailValidationServices;
		this.jExternalServices = jExternalServices;
	}
	

	public void register(User user) {
		
		checkMailIfReal(user.getEMail());
		
		if (!loginControllerServices.isEMailValid(user.getEMail())) {
			return;
		}
		System.out.println("E-Mail kontrolü başarılı...");
		
		if (!loginControllerServices.isValidPassword(user.getPassword())) {
			return;
		}
		System.out.println("Parola kontrolü başarılı...");
		
		if (!loginControllerServices.isValidFirstName(user.getFirstName())) {
			return;
		}
		System.out.println("İsim kontrolü başarılı...");
		
		if (!loginControllerServices.isValidLastName(user.getLastName())) {
			return;
		}
		System.out.println("Soyisim kontrolü başarılı...");
		
		userDao.add(user);
		eMailValidationServices.sendValidationEmailForUser(user);
		System.out.println("Merhaba! " + user.getFirstName() + " " + user.getLastName());
		System.out.println("Kayıt işlemi başarılı bir şekilde gerçekleşmiştir..." + "\n");
		jExternalServices.registerWith();
		
	}

	public void login(String email, String password) {
		
		if (loginControllerServices.isEMailValid(email)) {
			return;
		}
		if (loginControllerServices.isValidPassword(password)) {
			return;
		}
		for (User user : userDao.getAll()) {
			if (user.getEMail() == email && user.getPassword() == password) {
				System.out.println("Giriş Başarılı...!");
				return;
			}
			else {
				System.out.println("Giriş Başarısız...! Bilgileri kontrol ediniz...");
			}
		}
		
	}

	public void checkMailIfReal(String email) {
		for (User user : userDao.getAll()) {
			if (user.getEMail() == email) {
				throw new ArithmeticException("Belirtmiş olduğunuz e-posta adresi sistemde zaten kayıtlı...");
			}
		}
	}

}
