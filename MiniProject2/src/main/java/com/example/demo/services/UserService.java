package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;

import com.example.demo.entity.User;
import com.example.demo.repository.RandomUserRepository;
import com.example.demo.repository.UserGenderRepository;
import com.example.demo.repository.UserNationalityRepository;
import com.example.demo.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RandomUserRepository urRepository;

	@Autowired
	private UserGenderRepository userGenderRepository;
	
	@Autowired
	private UserNationalityRepository userNationalityRepository;

	private String nationality1;
	private String gender1;
	private String nationality2;
	private String gender2;

	public User add(User user) {
		return userRepository.save(user);
	}

	public List<User> findBySortType(String query) {
		List<User> userList = userRepository.searchUsers(query);
		return userList;
	}

	public List<User> findBySortOrder(String query) {
		List<User> userList = userRepository.searchUsers(query);
		return userList;
	}

	public User getRandomUser(User user) {
		User x = urRepository.random(user);
		nationality1 = x.getNationality();
		gender1 = x.getGender();
		return x;
	}

	public User userNationality(String query) {
		User user = userNationalityRepository.userNationality(query);
		nationality2 = user.getNationality();
		return user;
	}

	public User userGender(String name) {
		User user = userGenderRepository.userGender(name);
		gender2 = user.getGender();
		return user;
	}

	public User save(User user) {
		if (gender1 == gender2) {
			if (nationality1 == nationality2) {
				user.setVerfication_status("VERIFIED");
			} else {
				user.setVerfication_status("TO_BE_VERIFIED");
			}
		} else {
			user.setVerfication_status("TO_BE_VERIFIED");
		}
		return user;
	}

}
