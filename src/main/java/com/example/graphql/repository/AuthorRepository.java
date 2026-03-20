package com.example.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.modal.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author,String> {
}
