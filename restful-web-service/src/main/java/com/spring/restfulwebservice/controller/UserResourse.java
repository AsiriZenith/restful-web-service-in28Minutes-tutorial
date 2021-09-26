package com.spring.restfulwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restfulwebservice.model.User;
import com.spring.restfulwebservice.service.UserDaoService;

@RestController
public class UserResourse {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userDaoService.fingOne(id);
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userDaoService.Save(user);
	}
}
