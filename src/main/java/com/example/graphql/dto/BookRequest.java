package com.example.graphql.dto;

public record BookRequest(
    String name,
    int pageCount,
    AuthorInput author
) {

}
