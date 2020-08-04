package com.nd.SpringFramework51.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nd.SpringFramework51.model.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long>{

}
