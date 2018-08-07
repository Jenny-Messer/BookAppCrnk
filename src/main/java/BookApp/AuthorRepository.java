// Copyright (c) 2018 Travelex Ltd

package BookApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorRepository {

    private List<Author> authors = new ArrayList<Author>();

    Author addAuthor(Author author) {
        author.setId(UUID.randomUUID().toString());
        authors.add(author);
        return author;
    }

    Author findById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    Set<Author> findAuthorsByBook(String bookId) {
        return authors.stream().filter(book -> book.getId().equals(bookId)).collect(Collectors.toSet());
    }

    List<Author> findAll() {
        return authors;
    }

}
