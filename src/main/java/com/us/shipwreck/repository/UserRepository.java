package com.us.shipwreck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.us.shipwreck.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserByEmail(String email);
	//public void saveUser(User user);
}
