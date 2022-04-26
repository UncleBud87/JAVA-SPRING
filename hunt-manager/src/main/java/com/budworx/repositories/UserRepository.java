package com.budworx.repositories;

import com.budworx.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> 
{
	// select * from users where users.email=?
	public User findByEmail(String email);
}
