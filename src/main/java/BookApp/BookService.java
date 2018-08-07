// Copyright (c) 2018 Travelex Ltd

package BookApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    Book addBook(Book book){

        bookRepository.addBook(book);

        return book;

    }

    public Book getBook(String id){
        return bookRepository.findById(id);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String id){
        return getBooks()
                .stream()
                .filter(book -> book.getAuthorId().equals(id))
                .collect(Collectors.toList());
    }

    public Book addBookByAuthor(Book book, String id){
        book.setAuthorId(id);
        return bookRepository.addBook(book);
    }


}
