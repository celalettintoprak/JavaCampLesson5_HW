package Lesson5.core.abstracts;

import Lesson5.entities.concretes.User;

public interface EMailValidationServices {
	
	void sendValidationEmailForUser(User user);
	
}
