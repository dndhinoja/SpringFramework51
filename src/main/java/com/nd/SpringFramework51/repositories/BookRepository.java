package com.nd.SpringFramework51.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nd.SpringFramework51.model.Books;

public interface BookRepository extends CrudRepository<Books, Long>{

}
