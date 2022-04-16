package com.dojo.DojosAndNinjas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.DojosAndNinjas.models.Ninja;
import com.dojo.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	
	public void Create(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public Ninja ReadOne(Long id) {
		Optional<Ninja> ninja=ninjaRepository.findById(id);
		return ninja.isPresent()?ninja.get():null;
	}
	public ArrayList<Ninja> ReadAll(){
		ArrayList<Ninja> ninjas=(ArrayList<Ninja>)ninjaRepository.findAll();
		return ninjas;
	}
	
	public void Update(Ninja ninja) {
		Create(ninja);
	}
	
	public void Delete(Long id) {
		ninjaRepository.deleteById(id);
	}

}
