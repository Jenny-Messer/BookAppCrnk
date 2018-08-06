package dfgvhbj;// Copyright (c) 2018 Travelex Ltd

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {

    @RestController
    public class BookController {

        @RequestMapping("/")
        public String index() {
            return "Greetings from Spring Boot!";
        }

    }
}
