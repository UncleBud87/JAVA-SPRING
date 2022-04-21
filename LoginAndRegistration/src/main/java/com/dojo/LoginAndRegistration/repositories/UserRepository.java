package com.dojo.LoginAndRegistration.repositories;



import org.springframework.data.repository.CrudRepository;
import com.dojo.LoginAndRegistration.models.User;

public interface UserRepository extends CrudRepository<User,Long> 
{
	public User findByEmail(String email);
}
