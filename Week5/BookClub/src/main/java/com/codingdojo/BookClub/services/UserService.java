package com.codingdojo.BookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

		if(result.hasErrors()) 
			return null;
		else if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is already registered.");
			return null;
		}
		else if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match the password.");
			return null;
		}
		else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());

		if(result.hasErrors())
			return null;
		else if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "The email is not registered.");
			return null;
		}
		else if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())){
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		else {
			return potentialUser.get();
		}
	}
}
