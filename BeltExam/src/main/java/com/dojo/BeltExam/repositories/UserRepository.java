package com.dojo.BeltExam.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.BeltExam.models.User;



public interface UserRepository extends CrudRepository<User,Long> 
{
	// select * from users where users.email=?
	public User findByEmail(String email);
}
