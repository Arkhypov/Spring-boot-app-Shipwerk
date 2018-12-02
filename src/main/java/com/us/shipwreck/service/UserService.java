package com.us.shipwreck.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.us.shipwreck.model.Role;
import com.us.shipwreck.model.User;
import com.us.shipwreck.repository.RoleRepository;
import com.us.shipwreck.repository.UserRepository;

@Service("userService")
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return bCryptPasswordEncoder;
    }
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.saveAndFlush(user);
}
}
