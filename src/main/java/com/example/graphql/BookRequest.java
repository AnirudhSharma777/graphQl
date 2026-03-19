package com.example.graphql;


public record BookRequest(
    String name,
    int pageCount,
    AuthorInput author
) {

}
