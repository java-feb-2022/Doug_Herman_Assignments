package com.codingdojo.DojosAndNinjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repos.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
}
