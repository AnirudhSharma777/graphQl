package com.example.graphql;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String name;
    private int pageCount;
    private Author author;
}
// public record Book(
//     Integer id,
//     String name,
//     int pageCount,
//     Integer authorId
// ) {

//     public static List<Book> books = Arrays.asList(
//         new Book(1, "Effective Java", 416,1),
//         new Book(2,"Hitchhiker's Guide to the Galaxy", 208,2),
//         new Book(3,"Down Under",436,3),
//         new Book(4,"The Lord of the Rings", 1178,4)
//     );


    

//     public static Book getById(Integer id2) {
//        return books.stream()
//         .filter(book -> book.id().equals(id2))
//         .findFirst()
//         .orElse(null);
//     }

// }
