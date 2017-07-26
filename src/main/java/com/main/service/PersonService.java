package com.main.service;

import com.main.models.Person;
import com.main.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(Integer id) {
        return personRepository.findOne(id);
    }

    public Person save(Person person) {
        return personRepository.saveAndFlush(person);
    }

    public void delete(Integer id) {
        personRepository.delete(id);
    }
}
