package BookApp;// Copyright (c) 2018 Travelex Ltd

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

}
