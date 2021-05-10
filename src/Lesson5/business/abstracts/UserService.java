package Lesson5.business.abstracts;

import Lesson5.entities.concretes.User;

public interface UserService {
	
	void register(User user);
	void login(String email, String password);
	void checkMailIfReal(String email);
	
}
