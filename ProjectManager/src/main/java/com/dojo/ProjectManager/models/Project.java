package com.dojo.ProjectManager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Project Name cannot be blank")
	private String project_name;
	
	@Size(min=1,max=255,message="Project Description cannot be blank")
	private String project_description;
	
	@NotNull(message="Due date must be provided.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date due_date;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getProject_name()
	{
		return project_name;
	}
	
	public void setProject_name(String project_name)
	{
		this.project_name=project_name;
	}
	
	public String getProject_description()
	{
		return project_description;
	}
	
	public void setProject_description(String project_description)
	{
		this.project_description=project_description;
	}
	
	public Date getDue_date() {
		return this.due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	//project owner
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private User owner;
	
	public User getOwner() 
	{
		return this.owner;
	}
	
	public void setOwner(User owner)
	{
		this.owner=owner;
	}
	
	// users in the project.
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable
	(
		name="users_projects",
		joinColumns=@JoinColumn(name="project_id"),
		inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> users;

	public List<User> getUsers() 
	{
		return this.users;
	}

	public void setUsers(List<User> users) 
	{
		this.users = users;
	}
	// users task in project
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY)
	private List<Task> tasks;

	public List<Task> getTasks() 
	{
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) 
	{
		this.tasks = tasks;
	}
	
	public Project()
	{
		
	}

}
