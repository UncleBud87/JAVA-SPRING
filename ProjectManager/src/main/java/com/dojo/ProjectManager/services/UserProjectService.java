package com.dojo.ProjectManager.services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.ProjectManager.models.UserProject;
import com.dojo.ProjectManager.repositories.UserProjectRepository;

@Service
public class UserProjectService 
{
	@Autowired
	private UserProjectRepository userProjectRepository;
	
	public UserProjectService(UserProjectRepository userProjectRepository)
	{
		this.userProjectRepository=userProjectRepository;
	}
	
	public ArrayList<UserProject> FindByUserId(Long user_id)
	{
		return (ArrayList<UserProject>)userProjectRepository.findByUserId(user_id);
	}
	
	public ArrayList<UserProject> FindByUserIdNot(Long user_id)
	{
		return (ArrayList<UserProject>)userProjectRepository.findByUserIdNot(user_id);
	}

}
