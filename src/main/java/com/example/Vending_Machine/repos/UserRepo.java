package com.example.Vending_Machine.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vending_Machine.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
