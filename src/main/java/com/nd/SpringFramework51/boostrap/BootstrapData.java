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
		Publisher publisher = new Publisher();
		//Publisher publisher = new Publisher("Jaco", "USA", "Los Angeles", "California", "90001");
		publisher.setName("Jaco");
		publisher.setAddressLine("USA");
		publisher.setCity("Los Angeles");
		publisher.setState("California");
		publisher.setZip("90001");
		publisherRepository.save(publisher);
		
		System.out.println("Number of publisher : "+publisherRepository.count());
		
		Authors robin = new Authors("Robin", "Sharma");
		Books club = new Books("5 AM CLub", "2973738182836");
		
		robin.getBooks().add(club);
		club.getAuthors().add(robin);
		
		club.setPublisher(publisher);
		publisher.getBooks().add(club);
		
		authorRepository.save(robin);
		bookRepository.save(club);
		publisherRepository.save(publisher);
		
		System.out.println("Number of Books : "+ bookRepository.count());
		System.out.println("Number of books in publisher"+ publisher.getBooks().size());
		
		Authors a1 = new Authors("abc", "abc");
		Books b1 = new Books("AM", "3878237837397");
		
		a1.getBooks().add(b1);
		b1.getAuthors().add(a1);
		
		b1.setPublisher(publisher);
		publisher.getBooks().add(b1);
		
		authorRepository.save(a1);
		bookRepository.save(b1);
		publisherRepository.save(publisher);
		
		System.out.println("commit in master");
		System.out.println("Number of Books : "+ bookRepository.count());
		System.out.println("Number of books in publisher"+ publisher.getBooks().size());

		
	}

}
