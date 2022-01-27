package com.example.demolesson4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping (path = "/person/{id}")
    public String getPerson(@PathVariable("id") Integer id) {
        return personService.getPerson(id);
    }

    @GetMapping (path = "/fsb/person/{id}")
    public String getPersonWithPinCode(@RequestParam("pin-code") int pinCode, @PathVariable("id") Integer id) {
        return personService.getPersonWithPinCode(id, pinCode);
    }
}


