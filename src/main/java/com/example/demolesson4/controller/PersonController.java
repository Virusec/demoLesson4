package com.example.demolesson4.controller;

import com.example.demolesson4.service.PersonService;
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

    @GetMapping(path = "/get/person/{id}")
    public String getPerson(@PathVariable("id") Integer id) {
        return personService.getPersonName(id);
    }

    @GetMapping(path = "/get/fsb/person/{id}")
    public String getPersonWithPinCode(@RequestParam("pin-code") int pinCode, @PathVariable("id") Integer id) {
        return personService.getPersonNameWithPinCode(id, pinCode);
    }

    @GetMapping(path = "/put/person/{id}")
    public String updatePerson(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("block") Boolean block) {
        return personService.updatePerson(name, block, id);
    }

    @GetMapping(path = "/delete/person/{id}")
    public String removePerson(@PathVariable("id") Integer id) {
        return personService.removePerson(id);
    }

    @GetMapping(path = "/post/person")
    public String addPerson(@RequestParam("name") String name, @RequestParam("block") Boolean block) {
        return personService.addPerson(name, block);
    }
}


