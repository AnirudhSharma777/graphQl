package com.example.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void canGetBooks() {
        graphQlTester.document("books")
                .execute()
                .path("books")
                .entityList(Book.class)
                .hasSize(3);
    }

    @Test
    void shouldGetFirstBook() {
        this.graphQlTester 
                            .document("bookDetails")
                            .variable("id",1)
                            .execute()
                            .path("bookById")
                            .matchesJson("""
                            {
                                "id": 1,
                                "name": "Effective Java",
                                "pageCount": 416,
                                "author": {
                                "firstName": "Joshua",
                                "lastName": "Bloch"
                                }
                            }
                            """);
    }

}
