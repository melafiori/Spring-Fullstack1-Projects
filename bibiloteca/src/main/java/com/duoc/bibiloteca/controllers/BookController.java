package com.duoc.bibiloteca.controllers;

import com.duoc.bibiloteca.models.Book;
import com.duoc.bibiloteca.models.BookDTO;
import com.duoc.bibiloteca.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    // Encuentra TODOS los datos
    @GetMapping("/total" )
    public ResponseEntity<Map<String, Integer>> getTotal() {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getTotal());
    }


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.bookService.getAll()
        );
    }

    // Encuentra POR ID los datos "/api/v1/books/{id}"
    @GetMapping("/{id}" )
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.bookService.getById(id)
        );
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDTO>> getByAuthorDTO(@PathVariable String author) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.bookService.getByAuthorDTO(author)
        );
    }


    // Muestra por ISBN, se ocupa /isbn/{isbn} por
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getByIsbn(@PathVariable String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.bookService.getByIsbn(isbn)
        );
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<Map<String, Object>> getCountByPublishDate(@PathVariable int year) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getCountByPublishDate(year));
    }

    // Postea los datos JSON en la "base de datos"
    @PostMapping
    public ResponseEntity<Book> save(@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.bookService.save(book)
        );
    }

    // Actualiza un libro existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book book){
        book.setId(id); // Se asegura que el id de la URL se use
        return ResponseEntity.status(HttpStatus.OK).body(
                this.bookService.update(book)
        );
    }

    // Elimina un libro existente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }
}
