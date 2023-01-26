package springmongodb.app.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springmongodb.app.model.Book;
import springmongodb.app.repository.BookRepository;
import springmongodb.app.service.BookSerivce;

@RestController
public class BookController {
    @Autowired
    private BookSerivce bookSerivce;
    private BookRepository repository;
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        return bookSerivce.CreateBook(book);
    }
    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return bookSerivce.findAllBook();
    }
    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBook(@PathVariable String id) {
        return bookSerivce.findBookById(id);
    }
    @PutMapping("/update/{id}")
    public Optional<Book> updateBook(@RequestBody Book book , @PathVariable String id){
        return bookSerivce.updateBookById(book,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        return bookSerivce.deleteById(id);
    }
}
