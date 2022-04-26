package com.dojo.BeltExam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Title cannot be blank")
	private String title;
	
	@Size(min=1,max=255,message="Genre cannot be blank")
	private String genre;
	
	@Size(min=5,max=255,message="Lyrics required")
	private String lyrics;
	
	@PreUpdate
	public void preUpdate() 
	{
		count+=1;
	}
	
	private Integer count = 0;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Integer getCount()
	{
		return count;
	}
	
	public User getUser() 
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user=user;
	}
	
	public Song()
	{
		
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setGenre(String genre)
	{
		this.genre=genre;
	}
	
	public String getLyrics()
	{
		return lyrics;
	}
	
	public void setLyrics(String lyrics)
	{
		this.lyrics=lyrics;
	}
	
}
