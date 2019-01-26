package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {

    @GetMapping
    public String sayHello() {
        System.out.println("Hello from Dummy Controller!");

        return "foo";
    }
}
