package com.budworx.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.budworx.models.LoginUser;
import com.budworx.models.User;
import com.budworx.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService 
{
		@Autowired
		private UserRepository userRepository;
	
		public UserService(UserRepository userRepository)
		{
			this.userRepository=userRepository;
		}
	
		public Boolean IsLoggedIn(HttpSession session)
		{
			return session.getAttribute("user_id")!=null;
		}
	
		public void Logout(HttpSession session)
		{
			if(!IsLoggedIn(session)) return;
			session.removeAttribute("user_id");
		}
	
		public void Create(User user)
		{
			userRepository.save(user);
		}
		
		public User FindById(Long id)
		{
			Optional<User> user=userRepository.findById(id);
			return user.isPresent()?user.get():null;
		}
	
		public User FindByEmail(String email)
		{
			User user = userRepository.findByEmail(email);
			return user;
		}
	
	public User register(User user,BindingResult result)
	{
		User existing_user=userRepository.findByEmail(user.getEmail());
		int errors=0;
		if(existing_user!=null)
		{
			result.rejectValue("email","email_invalid","email is in use.");
			errors++;
		}
		if(!user.getPassword().equals(user.getConfirm()))
		{
			result.rejectValue("password","password_mismatch","Password and Password Confirmation must match.");
			errors++;
		}
		if(errors>0) return null;
		String hashed_pw=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(8));
		user.setPassword(hashed_pw);
		userRepository.save(user);
		return user;
	}

	public User login
	(
			LoginUser form_user,
			BindingResult result,
			HttpSession session
	)
	{
		User db_user=userRepository.findByEmail(form_user.getEmail());
		int errors=0;
		if(db_user==null)
		{
			result.rejectValue("email","invalid_email","Email not found.");
			errors++;
		}
		if(db_user!=null)
		{
			Boolean match=BCrypt.checkpw(form_user.getPassword(),db_user.getPassword());
			if(!match)
			{
				result.rejectValue("password", "invalid_password","invalid Password");
				errors++;
			}
		}
		if(errors>0) return null;
		session.setAttribute("user_id",db_user);
		session.setAttribute("user_name", db_user.getName());
		return db_user;
	}


}