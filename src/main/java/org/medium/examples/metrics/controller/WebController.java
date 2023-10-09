package org.medium.examples.metrics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.medium.examples.metrics.entity.IPerson;
import org.medium.examples.metrics.entity.Person;
import org.medium.examples.metrics.service.PersonService;
import org.medium.examples.metrics.utils.JsonUtils;
import org.springframework.aop.framework.DefaultAdvisorChainFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("person")
public class WebController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get")
    public Person getPerson(@RequestParam String id) throws JsonProcessingException {

        DefaultAdvisorChainFactory f = new DefaultAdvisorChainFactory();
        String s = JsonUtils.convertObjectToJsonString(f);
        System.out.println(s);
        Person person = personService.getPerson(id);
        return person;
    }

    @PostMapping("/upload")
    public Person uploadPerson(@RequestParam String id,
            @RequestParam String name, @RequestParam int age) {
        Person person = personService.addPerson(id, name, age);
        return person;
    }

    @GetMapping("/page")
    public String page() throws JsonProcessingException {
        Page<IPerson> persons = personService.list();
        return JsonUtils.convertObjectToJsonString(persons);
    }
}
