package dev.ericrybarczyk.todorest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        if (LocalDateTime.now().getSecond() % 2 == 1) {
            throw new RuntimeException("That's odd, something went wrong on the server. Sorry!");
        }
        return new HelloWorldBean(String.format("Hello World, it is %s", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
    }

    @GetMapping({"", "/", "/hello-world-bean/path-var/{name}"})
    public HelloWorldBean helloWorldPath(@PathVariable String name) {
        if (LocalDateTime.now().getSecond() % 2 == 1) {
            throw new RuntimeException("That's odd, something went wrong on the server. Sorry!");
        }
        return new HelloWorldBean(String.format("Hello %s, it is %s", name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
    }
}
