package com.dojo.BookClub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Size(min=1,max=255,message="Title cannot be blank")
		private String title;
		
		@Size(min=1,max=255,message="Author cannot be blank")
		private String author;
		
		@Size(min=1,max=255,message="description cannot be blank")
		private String description;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
		public Book()
		{
			
		}
		
		public User getUser() 
		{
			return user;
		}
		
		public void setUser(User user)
		{
			this.user=user;
		}
		
		public Long getId()
		{
			return id;
		}
		
		public void setId(Long id)
		{
			this.id = id;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public void setDescription(String description)
		{
			this.description=description;
		}
		
		public String getTitle()
		{
			return title;
		}
		
		public void setTitle(String title)
		{
			this.title=title;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public void setAuthor(String author)
		{
			this.author=author;
		}
		
		

}
