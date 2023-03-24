package merveozer.multipledb.primary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import merveozer.multipledb.primary.model.UserInfo;
import merveozer.multipledb.primary.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	List<UserInfo> getUsers() {
		return this.userRepository.findAll();
	}
	
	@PostMapping("/users")
	List<UserInfo> addUser(@RequestBody UserInfo userInfo) {
		userRepository.save(userInfo);
		return userRepository.findAll();	
	}

}
