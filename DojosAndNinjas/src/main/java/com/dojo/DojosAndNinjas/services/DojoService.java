package com.dojo.DojosAndNinjas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.DojosAndNinjas.models.Dojo;
import com.dojo.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	public void Create(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public Dojo ReadOne(Long id) {
		Optional<Dojo> dojo=dojoRepository.findById(id);
		return dojo.isPresent()?dojo.get():null;
	}
	public ArrayList<Dojo> ReadAll(){
		ArrayList<Dojo> dojos=(ArrayList<Dojo>)dojoRepository.findAll();
		return dojos;
	}
	
	public void Update(Dojo dojo) {
		Create(dojo);
	}
	
	public void Delete(Long id) {
		dojoRepository.deleteById(id);
	}
	
}
