package com.example.actest.repository;

import com.example.actest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

    List<Person> findAll();

    Person findById(int id);

    List<Person> findByColor(String color);

}
