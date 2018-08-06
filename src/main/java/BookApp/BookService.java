// Copyright (c) 2018 Travelex Ltd

package BookApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
