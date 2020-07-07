package com.example.actest.service;

import com.example.actest.repository.PersonRepository;
import com.example.actest.repository.PersonRepositoryImpl;
import com.example.actest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> retrieveALlPersons() {
        return personRepository.findAll();
    }

    public Person retrievePersonById(int id) {
        return personRepository.findById(id);
    }

    public List<Person> retrievePersonsByColor(String color) {
        return personRepository.findByColor(color);
    }

}
