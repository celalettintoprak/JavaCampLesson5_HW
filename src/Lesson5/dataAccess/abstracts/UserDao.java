package Lesson5.dataAccess.abstracts;

import java.util.List;

import Lesson5.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void update(User user);
	
	User getId(int id);
	User getMail(String eMail);
	
	List<User> getAll();
	
}
