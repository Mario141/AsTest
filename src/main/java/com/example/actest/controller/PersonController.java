package com.example.actest.controller;

import com.example.actest.service.PersonService;
import com.example.actest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * the controller that can handle request and return a response
 * @author Renhao Zheng
 */
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> list = personService.retrieveALlPersons();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        Person person = personService.retrievePersonById(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @GetMapping("/persons/color/{color}")
    public ResponseEntity<List<Person>> getPersonsByColor(@PathVariable String color) {
        List<Person> list = personService.retrievePersonsByColor(color);
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

}
