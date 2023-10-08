package com.example.Vending_Machine.controller;

import com.example.Vending_Machine.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.Vending_Machine.dto.UserRequestDTO;
import com.example.Vending_Machine.model.User;
import com.example.Vending_Machine.service.UserService;

import java.util.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequestDTO) {
		User user = new User();
		if (userRequestDTO != null) {
			if (userRequestDTO.getRole().equals(UserRoles.BUYER.toString())) {
				String[] availableDeposit = {"5", "10", "20", "50", "100"};
				for (String depositAmount : availableDeposit) {
					if (depositAmount.equals(userRequestDTO.getDeposit())) {
						user.setDeposit(userRequestDTO.getDeposit());
						user.setSavesDeposit(userRequestDTO.getDeposit());
					} else {
						//return ResponseEntity.badRequest();
						System.out.println("deposit Amount doesnot available");
					}
				}

			}
			user.setUserName(userRequestDTO.getUserName());
			user.setPassword(userRequestDTO.getPassword());

			user.setRole(userRequestDTO.getRole());

		}
		return ResponseEntity.ok().body(this.userService.save(user));
	}

	@GetMapping("/users/reset")
	public ResponseEntity<User> resetDeposit(@RequestBody UserRequestDTO userRequestDTO) {
//		if loggined user roll == buyer
		User user = userService.getUserById(Long.valueOf(userRequestDTO.getId()));
		user.setDeposit(user.getSavesDeposit());
		return ResponseEntity.ok().body(this.userService.update(user));
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(this.userService.getAllUsers());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateProduct(@PathVariable long id, @RequestBody UserRequestDTO userRequestDTO) {
		User user = new User();
		user.setId(id);
		user.setUserName(userRequestDTO.getUserName());
		user.setPassword(userRequestDTO.getPassword());
		user.setRole(userRequestDTO.getRole());
		user.setDeposit(userRequestDTO.getDeposit());
		user.setSavesDeposit(userRequestDTO.getDeposit());
		return ResponseEntity.ok().body(this.userService.update(user));
	}

	@DeleteMapping("/users/{id}")
	public HttpStatus deleteUser(@PathVariable long id) {
		this.userService.deleteUser(id);
		return HttpStatus.OK;
	}

//
}


