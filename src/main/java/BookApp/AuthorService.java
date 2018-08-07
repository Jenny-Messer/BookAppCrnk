// Copyright (c) 2018 Travelex Ltd

package BookApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author){

        authorRepository.addAuthor(author);

        return author;

    }

    public Author getAuthor(String id){
        return authorRepository.findById(id);
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }


}
