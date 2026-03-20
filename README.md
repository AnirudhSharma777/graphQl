# GraphQL Book Management API

A Spring Boot GraphQL application for managing books and authors with MongoDB as the database.

## Overview

This project implements a GraphQL API that provides queries and mutations for managing books and their authors. It leverages Spring Boot's GraphQL starter and MongoDB for persistent data storage.

## Technology Stack

- **Framework**: Spring Boot 3.5.3
- **API**: Spring GraphQL
- **Database**: MongoDB
- **Language**: Java 17
- **Build Tool**: Gradle
- **Testing**: JUnit 5, Spring GraphQL Test
- **Build/Deployment**: Docker
- **Code Generation**: Lombok

## Prerequisites

- Java 17 or higher
- Gradle 7.x or higher (or use the included `gradlew`)
- MongoDB 4.x or higher
- Docker (optional, for containerized deployment)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd graphQl
```

### 2. Configure MongoDB

Update `src/main/resources/application.properties` with your MongoDB connection details:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/graphQl
spring.data.mongodb.database=graphQl
```

Ensure MongoDB is running on your machine or in a Docker container:

```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```

### 3. Build the Project

```bash
./gradlew build
```

On Windows:
```bash
gradlew.bat build
```

## Running the Application

### Development

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### Access GraphiQL

Visit `http://localhost:8080/graphiql` in your browser to access the interactive GraphQL IDE.

### Production Build

```bash
./gradlew build
java -jar build/libs/graphQl-0.0.1-SNAPSHOT.jar
```

## Docker Deployment

Build the Docker image:

```bash
docker build -t graphql-app .
```

Run the container:

```bash
docker run -d -p 8080:8080 --link mongodb:mongodb --name graphql-app graphql-app
```

## API Schema

### Queries

#### Get All Books
```graphql
query {
  books {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

#### Get Book by ID
```graphql
query {
  bookById(id: "1") {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

#### Get All Authors
```graphql
query {
  authors {
    id
    firstName
    lastName
  }
}
```

#### Get Author by ID
```graphql
query {
  authorById(id: "1") {
    id
    firstName
    lastName
  }
}
```

### Mutations

#### Create a Book
```graphql
mutation {
  createBook(book: {
    name: "Clean Code"
    pageCount: 464
    author: {
      firstName: "Robert"
      lastName: "Martin"
    }
  }) {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

#### Update a Book
```graphql
mutation {
  updateBook(id: "1", book: {
    name: "Updated Title"
    pageCount: 500
    author: {
      firstName: "John"
      lastName: "Doe"
    }
  }) {
    id
    name
    pageCount
  }
}
```

#### Delete a Book
```graphql
mutation {
  deleteBook(id: "1")
}
```

## Project Structure

```
graphQl/
├── src/
│   ├── main/
│   │   ├── java/com/example/graphql/
│   │   │   ├── controller/        # GraphQL controller
│   │   │   ├── modal/             # Entity classes (Book, Author)
│   │   │   ├── repository/        # MongoDB repositories
│   │   │   ├── AuthorInput.java   # GraphQL input type
│   │   │   ├── BookRequest.java   # GraphQL input type
│   │   │   └── GraphQlApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── graphql/
│   │           └── schema.graphqls  # GraphQL schema definition
│   └── test/
│       ├── java/                   # Unit tests
│       └── resources/
│           └── graphql-test/       # Test GraphQL queries
├── build.gradle                    # Gradle build configuration
├── Dockerfile                      # Docker configuration
└── README.md                       # This file
```

## Key Components

### Entities

- **Book**: Represents a book with id, name, pageCount, and associated author
- **Author**: Represents an author with id, firstName, and lastName

### Repositories

- **BookRepository**: Spring Data MongoDB repository for Book operations
- **AuthorRepository**: Spring Data MongoDB repository for Author operations

### Controller

- **BookController**: Handles GraphQL queries and mutations

## Testing

Run the test suite:

```bash
./gradlew test
```

Tests are located in `src/test/java/com/example/graphql/` and include:
- `BookControllerTest`: Tests for book operations
- `GraphQlApplicationTests`: Application context tests

GraphQL test queries/mutations are in `src/test/resources/graphql-test/`

## Configuration

Modify `src/main/resources/application.properties` to customize:

- Application name
- GraphiQL settings
- MongoDB connection URI and database name
- Server port and other Spring Boot settings

## Development

### Building in Development Mode

```bash
./gradlew clean build
```

### Running Tests with Coverage

```bash
./gradlew test --info
```

### Common Gradle Tasks

- `./gradlew build` - Build the project
- `./gradlew bootRun` - Run the application
- `./gradlew test` - Run tests
- `./gradlew clean` - Clean build artifacts
- `./gradlew dependencies` - View project dependencies

## Troubleshooting

### MongoDB Connection Issues

- Ensure MongoDB is running: `mongo --version`
- Check connection URI in `application.properties`
- Verify MongoDB is accessible at `localhost:27017`

### Port Already in Use

If port 8080 is already in use, change it in `application.properties`:

```properties
server.port=8081
```

### GraphiQL Not Loading

- Ensure `spring.graphql.graphiql.enabled=true` is set
- Check that the application is running on the correct port
- Clear browser cache and hard refresh (Ctrl+Shift+R)

## Contributing

1. Create a feature branch: `git checkout -b feature/your-feature`
2. Make your changes and commit: `git commit -am 'Add feature'`
3. Push to the branch: `git push origin feature/your-feature`
4. Submit a pull request

## License

This project is provided as-is for educational and commercial purposes.

## Contact & Support

For issues, questions, or suggestions, please open an issue in the repository or contact the development team.
