package com.nd.SpringFramework51.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	private Set<Books> books = new HashSet<>();
	
	public Authors() {
		
	}
	
	public Authors(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}
	
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authors other = (Authors) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", books="
				+ books + "]";
	}

	
}
