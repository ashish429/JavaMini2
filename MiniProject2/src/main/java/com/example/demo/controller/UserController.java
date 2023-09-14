package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

	private int size = 0;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
		User userObj = null;
		if (size <= 5) {
			userObj = userService.add(user);
		} else if (size > 5) {
			return new ResponseEntity<>("Total User is already 5 so no user can add on.", HttpStatus.OK);
		}
		size++;
		return ResponseEntity.ok(userObj);
	}

	@GetMapping("/users/{sortOption}/{query}")
	public ResponseEntity<User> getUser(@PathVariable String sortOption, String query) {
		User user = null;
		if (sortOption == "sortType") {
			user = (User) userService.findBySortType(query);
		} else {
			user = (User) userService.findBySortOrder(query);
		}
		return ResponseEntity.ok(user);
	}
	
}
