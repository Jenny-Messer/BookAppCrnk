package BookApp;// Copyright (c) 2018 Travelex Ltd

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BookApp.class);
        app.run();
    }

}
