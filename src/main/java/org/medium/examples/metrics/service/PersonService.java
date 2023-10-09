package org.medium.examples.metrics.service;

import java.util.Objects;
import org.medium.examples.metrics.entity.IPerson;
import org.medium.examples.metrics.entity.Person;
import org.medium.examples.metrics.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(String id) {
        Person person = personRepository.getPersonById(id);
        if (Objects.nonNull(person)) {
            double salary = 5000.00;
            person.setSalary(salary);
        }
        return person;
    }

    public Person addPerson(String id, String name, int age) {
        Person person = personRepository.getPersonById(id);
        if (Objects.nonNull(person)) {
           throw new RuntimeException("user id conflict");
        }
        person = new Person(name, age, id);
        personRepository.save(person);
        return person;
    }

    public Page<IPerson> list() {
        Pageable pageable = PageRequest.of(1, 1);
        return personRepository.page(pageable);
    }

}
