package com.duoc.bibiloteca.repositories;

import com.duoc.bibiloteca.exceptions.BookException;
import com.duoc.bibiloteca.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> getAll(){
        return this.bookList;
    }

    public List<Book> findByAuthor(String author){
        List<Book> books = new ArrayList<>();
        for (Book book : this.bookList){
            if(book.getAuthor().equals(author)){
                // Si el autor proporcionado existe en un libro, se añade
                // el libro a la lista creada
                books.add(book);

            }
        }
        return books;
    }

    public Book findById(Long id){
        for(Book book : this.bookList){
            if(Objects.equals(book.getId(), id)){
                return book;
            }
        }
        return null;
    }

    public Book findByIsbn(String isbn){
        for(Book book : this.bookList){
            if(Objects.equals(book.getIsbn(), isbn)){
                return book;
            }
        }
        return null;
    }

    public Book save(Book newBook){
        Book bookFindId = this.findById(newBook.getId());
        if(bookFindId == null){
            Book bookFindIsbn = this.findByIsbn(newBook.getIsbn());
            if (bookFindIsbn == null){
                this.bookList.add(newBook);
                return newBook;
            }else {
                throw new BookException("Book with Isbn "+newBook.getIsbn() +" already exists");
            }
        }else{
            throw new BookException("Book with ID " +newBook.getId() + " already exists");
        }
    }

    public Book update(Book updatedBook){
        int position = 0;
        boolean find = false;
        for(int i=0; i<this.bookList.size(); i++){
            if(this.bookList.get(i).getId().equals(updatedBook.getId())){
                position = i;
                find = true;
                break;
            }
        }
        // if (find) es lo mismo que if (find == True)
        if (find){
            this.bookList.set(position, updatedBook);
            return updatedBook;
        }else{
            throw new RuntimeException("Book with ID " + updatedBook.getId() + " does not exist");
        }
    }
    public void deleteById(Long id){
        Book book = this.findById(id);
        this.bookList.remove(book);
    }

    public BookRepository(){
        bookList.add(new Book(1L, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        bookList.add(new Book(2L, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        bookList.add(new Book(3L, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        bookList.add(new Book(4L, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        bookList.add(new Book(5L, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        bookList.add(new Book(6L, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        bookList.add(new Book(7L, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
        bookList.add(new Book(8L, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        bookList.add(new Book(9L, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        bookList.add(new Book(10L, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    public int countByPublishDate(int year){
        int count = 0;
        for(Book book : this.bookList){
            if (book.getPublishDate() == year){
                count++;
            }
        }
        return count;
    }
}
