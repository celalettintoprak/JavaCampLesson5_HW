package Lesson5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Lesson5.dataAccess.abstracts.UserDao;
import Lesson5.entities.concretes.User;

public class AbcUserDao implements UserDao {
	
	List<User> users = new ArrayList<User>();

	public void add(User user) {
		users.add(user);
		System.out.println("\n" + user.getFirstName() + " " + user.getLastName() + " kullanıcısı eklendi...");
		System.out.println("E-Posta Adresi: " + user.getEMail() + "\n");
	}

	public void delete(User user) {
		users.remove(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " adlı kullanıcı silindi..." + "\n");
	}

	public void update(User user) {
		System.out.println(user.getFirstName() + " adlı kullanıcı bilgileri güncellendi..." + "\n");
	}

	public User getId(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User getMail(String eMail) {
		for (User user : users) {
			if (user.getEMail() == eMail) {
				return user;
			}
		}
		return null;
	}

	public List<User> getAll() {
		return users;
	}

}
