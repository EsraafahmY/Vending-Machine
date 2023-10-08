package com.example.Vending_Machine.service.Impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Vending_Machine.model.User;
import com.example.Vending_Machine.repos.UserRepo;
import com.example.Vending_Machine.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		Optional<User> userobj = this.userRepo.findById(user.getId());
		if(userobj.isPresent()) {
			User updatedUser = userobj.get();
//			updatedUser.setId(user.getId());
			updatedUser.setUserName(user.getUserName());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setDeposit(user.getDeposit());
			updatedUser.setRole(user.getRole());
			userRepo.save(user);
			return updatedUser;
		}else {
       System.out.println("error in update user");
		}
        return user;
    }

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = this.userRepo.findById(id);

		if(user.isPresent()) {
			return user.get();
		}else {
			System.out.println("can't find user");		}
        return user.get();
    }

	@Override
	public void deleteUser(long id) {
		Optional<User> user = this.userRepo.findById(id);

		if(user.isPresent()) {
			this.userRepo.delete(user.get());
		}else {
			System.out.println("error in delete user");		}
	}

}
