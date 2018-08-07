// Copyright (c) 2018 Travelex Ltd

package BookApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookRepository {

    private List<Book> books = new ArrayList<Book>();

    Book addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        return book;
    }

    Book findById(String id) {
       return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    List<Book> findAll() {
        return books;
    }

}
