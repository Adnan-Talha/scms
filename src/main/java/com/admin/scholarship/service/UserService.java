package com.admin.scholarship.service;

import com.admin.scholarship.model.User;
import com.admin.scholarship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates user credentials against the database.
     *
     * @param username input from login form
     * @param password input from login form
     * @param role     input from login form
     * @return true if valid credentials, false otherwise
     */
    public boolean validateUser(String username, String password, String role) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return false;
        }

        // Basic string comparison. You may want to hash passwords in a real app.
        return user.getPassword().equals(password) &&
               user.getRole().equalsIgnoreCase(role);
    }

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
}
