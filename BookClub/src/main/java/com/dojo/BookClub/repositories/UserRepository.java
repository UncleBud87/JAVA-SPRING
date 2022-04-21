package com.dojo.BookClub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.BookClub.models.User;

public interface UserRepository extends CrudRepository<User,Long> 
{
	// select * from users where users.email=?
	public User findByEmail(String email);
}
