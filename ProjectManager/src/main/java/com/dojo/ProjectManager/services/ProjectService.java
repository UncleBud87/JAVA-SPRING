package com.dojo.ProjectManager.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.ProjectManager.models.Project;
import com.dojo.ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService 
{
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository)
	{
		this.projectRepository=projectRepository;
	}
	
	public ArrayList<Project> ReadAll()
	{
		return (ArrayList<Project>)projectRepository.findAll();
	}
	
	public void Create(Project project)
	{
		projectRepository.save(project);
	}
	
	public void Delete(Long project_id)
	{
		projectRepository.deleteById(project_id);
	}
	
	public Project ReadOne(Long project_id)
	{
		Optional<Project> project=projectRepository.findById(project_id);
		return project.isPresent()?project.get():null;
	}

}
