package com.nd.SpringFramework51.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nd.SpringFramework51.model.Books;
import com.nd.SpringFramework51.model.Publisher;
import com.nd.SpringFramework51.repositories.AuthorRepository;
import com.nd.SpringFramework51.repositories.BookRepository;
import com.nd.SpringFramework51.repositories.PublisherRepository;
import com.nd.SpringFramework51.model.Authors;

@Component
public class BootstrapData implements CommandLineRunner{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BootStrap Started");
		Authors robin = new Authors("Robin", "Sharma");
		Books club = new Books("5 AM CLub", "2973738182836");
		robin.getBooks().add(club);
		club.getAuthors().add(robin);

		authorRepository.save(robin);
		bookRepository.save(club);

		Publisher publisher = new Publisher("Jaco", "USA", "Los Angeles", "California", "90001");
		publisherRepository.save(publisher);
		System.out.println("BootStrap Started");
	}

}
