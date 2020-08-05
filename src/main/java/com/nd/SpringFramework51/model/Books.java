package com.nd.SpringFramework51.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long booksId;
	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name = "AUTHOR_BOOK", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	private Set<Authors> authors = new HashSet<>();
	
	@ManyToOne
	private Publisher publisher;

	public Books() {

	}

	public Books(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	
	public Long getBooksId() {
		return booksId;
	}

	public void setBooksId(Long booksId) {
		this.booksId = booksId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booksId == null) ? 0 : booksId.hashCode());
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
		Books other = (Books) obj;
		if (booksId == null) {
			if (other.booksId != null)
				return false;
		} else if (!booksId.equals(other.booksId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [booksId=" + booksId + ", title=" + title + ", isbn=" + isbn + ", author=" + authors + "]";
	}
	
}
