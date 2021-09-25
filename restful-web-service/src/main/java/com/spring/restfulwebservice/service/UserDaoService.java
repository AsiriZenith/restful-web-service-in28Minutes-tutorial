package com.spring.restfulwebservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.restfulwebservice.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 4;
	
	static {
		users.add(new User(1,"Asiri", new Date()));
		users.add(new User(2,"Neja", new Date()));
		users.add(new User(3,"Supun", new Date()));
		users.add(new User(4,"Mauli", new Date()));
	}
	
	public List<User> findAllUsers() {
		return users;
	}
	
	public User Save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User fingOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
