package BookApp;// Copyright (c) 2018 Travelex Ltd

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable String id){
        return authorService.getAuthor(id);
    }

    @RequestMapping(value = "/authors/{id}/books", method = RequestMethod.GET)
    public List<Book> getBooksByAuthor(@PathVariable String id){
        return bookService.getBooksByAuthor(id);
    }

    @RequestMapping(value = "/authors/{id}/books", method = RequestMethod.POST)
    public Book addBooksByAuthor(@PathVariable String id, @RequestBody Book book){
        return bookService.addBookByAuthor(book, id);
    }



}
