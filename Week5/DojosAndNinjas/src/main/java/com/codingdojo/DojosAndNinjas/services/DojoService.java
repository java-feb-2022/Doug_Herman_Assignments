package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.repos.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent())
			return optionalDojo.get();
		else
			return null;
	}
}
