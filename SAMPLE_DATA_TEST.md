# GraphQL CRUD Operations - Sample Test Data

## 1. CREATE Operations (Mutations)

### Create Book 1
```graphql
mutation {
  createBook(book: {
    name: "The Great Gatsby"
    pageCount: 180
    authorId: 1
  }) {
    id
    name
    pageCount
  }
}
```

### Create Book 2
```graphql
mutation {
  createBook(book: {
    name: "Spring in Action"
    pageCount: 520
    authorId: 2
  }) {
    id
    name
    pageCount
  }
}
```

### Create Book 3
```graphql
mutation {
  createBook(book: {
    name: "To Kill a Mockingbird"
    pageCount: 281
    authorId: 3
  }) {
    id
    name
    pageCount
  }
}
```

### Create Book 4
```graphql
mutation {
  createBook(book: {
    name: "1984"
    pageCount: 328
    authorId: 4
  }) {
    id
    name
    pageCount
  }
}
```

---

## 2. READ Operations (Queries)

### Get All Books
```graphql
query {
  books {
    id
    name
    pageCount
  }
}
```

### Get Book by ID (1)
```graphql
query {
  bookById(id: 1) {
    id
    name
    pageCount
  }
}
```

### Get Book by ID (2)
```graphql
query {
  bookById(id: 2) {
    id
    name
    pageCount
  }
}
```

---

## 3. UPDATE Operations (Mutations)

### Update Book 1 - Change Title
```graphql
mutation {
  updateBook(id: 1, book: {
    name: "The Great Gatsby (Revised Edition)"
    pageCount: 200
    authorId: 1
  }) {
    id
    name
    pageCount
  }
}
```

### Update Book 2 - Change Page Count
```graphql
mutation {
  updateBook(id: 2, book: {
    name: "Spring in Action"
    pageCount: 600
    authorId: 2
  }) {
    id
    name
    pageCount
  }
}
```

### Update Book 3 - Full Update
```graphql
mutation {
  updateBook(id: 3, book: {
    name: "To Kill a Mockingbird (New Edition)"
    pageCount: 300
    authorId: 5
  }) {
    id
    name
    pageCount
  }
}
```

---

## 4. DELETE Operations (Mutations)

### Delete Book 4
```graphql
mutation {
  deleteBook(id: 4)
}
```

---

## 5. Complete Test Sequence

Run these mutations and queries in order to test the entire workflow:

### Step 1: Create 4 Books
Run Create Book 1, 2, 3, and 4 mutations above (copy each query individually)

**Expected Result:** Each mutation returns the created book with auto-generated ID

### Step 2: Retrieve All Books
```graphql
query {
  books {
    id
    name
    pageCount
  }
}
```

**Expected Result:** Returns array of 4 books

### Step 3: Get Single Book
```graphql
query {
  bookById(id: 1) {
    id
    name
    pageCount
  }
}
```

**Expected Result:** Returns book with id: 1

### Step 4: Update a Book
```graphql
mutation {
  updateBook(id: 1, book: {
    name: "The Great Gatsby (Updated)"
    pageCount: 250
    authorId: 1
  }) {
    id
    name
    pageCount
  }
}
```

**Expected Result:** Book with id: 1 has updated name and pageCount

### Step 5: Delete a Book
```graphql
mutation {
  deleteBook(id: 4)
}
```

**Expected Result:** Returns `true` on successful deletion

### Step 6: Verify Deletion
```graphql
query {
  books {
    id
    name
    pageCount
  }
}
```

**Expected Result:** Returns 3 books (book with id: 4 is deleted)

---

## Testing Instructions

1. Start your Spring Boot application
2. Open GraphQL Playground at: `http://localhost:8080/graphiql` (or `/graphql`)
3. Copy each query/mutation above into the editor
4. Click the play button to execute
5. Review the response on the right side

---

## Sample JSON Data for MongoDB (Optional Direct Insert)

If you want to seed the database directly via MongoDB:

```json
{
  "_id": 1,
  "name": "The Great Gatsby",
  "pageCount": 180,
  "authorId": 1,
  "_class": "com.example.graphql.Book"
}

{
  "_id": 2,
  "name": "Spring in Action",
  "pageCount": 520,
  "authorId": 2,
  "_class": "com.example.graphql.Book"
}

{
  "_id": 3,
  "name": "To Kill a Mockingbird",
  "pageCount": 281,
  "authorId": 3,
  "_class": "com.example.graphql.Book"
}

{
  "_id": 4,
  "name": "1984",
  "pageCount": 328,
  "authorId": 4,
  "_class": "com.example.graphql.Book"
}
```
