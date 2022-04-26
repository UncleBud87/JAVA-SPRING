package com.budworx.huntmanager.repositories;

import com.budworx.huntmanager.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> 
{
	// select * from users where users.email=?
	public User findByEmail(String email);
}
