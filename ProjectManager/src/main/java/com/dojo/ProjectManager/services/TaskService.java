package com.dojo.ProjectManager.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.ProjectManager.models.Task;
import com.dojo.ProjectManager.repositories.TaskRepository;

@Service
public class TaskService 
{
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository=taskRepository;
	}
	
	public ArrayList<Task> ReadAll()
	{
		return (ArrayList<Task>)taskRepository.findAll();
	}
	
	public Task ReadOne(Long task_id)
	{
		Optional<Task> task=taskRepository.findById(task_id);
		return task.isPresent()?task.get():null;
	}
	
	public void Create(Task task)
	{
		taskRepository.save(task);
	}
	
	public void Delete(Long task_id)
	{
		taskRepository.deleteById(task_id);
	}

}
