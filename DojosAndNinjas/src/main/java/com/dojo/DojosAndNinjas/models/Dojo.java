package com.dojo.DojosAndNinjas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Dojo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Name cannot be blank")
	private String name;
	
	@OneToMany(mappedBy="dojo",fetch=FetchType.LAZY)
	private List<Ninja> ninjas;
	
	
	public List<Ninja> getNinjas() {
		return ninjas;
	}


	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getName( ) {
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public Dojo()
	{
		
	}
	public Dojo(String name)
	{
		this.name=name;
	}
	
}
