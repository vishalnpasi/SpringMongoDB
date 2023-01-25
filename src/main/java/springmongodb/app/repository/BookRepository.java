package springmongodb.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springmongodb.app.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}

