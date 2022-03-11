package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	// This method will be called from the controller
	// whenever a user submits a registration form.

	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		// TO-DO - Reject values or register if no errors:
		// Return null if result has errors
		if(result.hasErrors()) 
			return null;
		// Reject if email is taken (present in database)
		else if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is already registered.");
			return null;
		}
		// Reject if password doesn't match confirmation
		else if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match the password.");
			return null;
		}
		// Hash and set password, save user to database
		else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	
	// This method will be called from the controller
	// whenever a user submits a login form.
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		// TO-DO - Reject values:
		if(result.hasErrors())
			return null;
		// Find user in the DB by email
		// Reject if NOT present
		else if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is not registered.");
			return null;
		}
		// Reject if BCrypt password match fails
		else if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())){
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		// Return null if result has errors
		// Otherwise, return the user object
		else {
			return potentialUser.get();
		}
	}
}
