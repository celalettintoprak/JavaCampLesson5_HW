package Lesson5;

import Lesson5.business.concretes.UserManager;
import Lesson5.core.concretes.EMailValidationManager;
import Lesson5.core.concretes.JGoogleManagerAdapter;
import Lesson5.core.concretes.LoginControllerManager;
import Lesson5.dataAccess.concretes.AbcUserDao;
import Lesson5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager(new LoginControllerManager(), new AbcUserDao(), new EMailValidationManager(), new JGoogleManagerAdapter());

		User user1 = new User(1, "Ayhan", "Karaman", "ayhan.k@gmail.com", "123456");
		User user2 = new User(2, "Kamil", "Vecihi", "kvecihi@hotmail.com.tr", "123456");
		User user3 = new User(3, "Fatma", "Sonunda", "fatmasonunda@yahoo.com", "123456");
		User user4 = new User(4, "Nurdan", "Akyıldız", "nurdan123@yandex.ru", "123456");
		User user5 = new User(5, "Lale", "Çiçek", "lalezar@gcicek.co.uk", "123456");
		
		userManager.register(user1);
		userManager.register(user2);
		userManager.register(user3);
		userManager.register(user4);
		userManager.register(user5);
		
		System.out.println("\n" + "*************************");
		userManager.login("ayhan.k@gmail.com", "123456");
		
		/*
		AbcUserDao abcUserDao = new AbcUserDao();
		
		abcUserDao.update(user4);
		abcUserDao.delete(user5);
		*/
		
	}

}
