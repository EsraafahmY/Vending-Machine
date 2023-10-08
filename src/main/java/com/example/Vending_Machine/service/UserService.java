package com.example.Vending_Machine.service;

import java.util.List;

import com.example.Vending_Machine.model.User;

public interface UserService {
	User save(User user);

	User update(User user);

	List<User> getAllUsers();
	User getUserById(long Id);

	void deleteUser(long id);
}
