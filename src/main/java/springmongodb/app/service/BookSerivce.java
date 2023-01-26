package springmongodb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmongodb.app.model.Book;
import springmongodb.app.repository.BookRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BookSerivce {
    @Autowired
    private BookRepository bookRepository;
    public String CreateBook(Book book){
        bookRepository.save(book);
        return "Added book with id : " + book.getId();
    }
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }
    public Optional<Book>  findBookById(String id){
        return bookRepository.findById(id);
    }
    public Optional<Book> updateBookById(Book book, String id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book oldBook = bookOptional.get();
        oldBook.setBookName(book.getBookName());
        bookRepository.save(oldBook);
        return bookOptional;
    }
    public String deleteById(String id){
        bookRepository.deleteById(id);
        return "book deleted with id : " + id;
    }
}
