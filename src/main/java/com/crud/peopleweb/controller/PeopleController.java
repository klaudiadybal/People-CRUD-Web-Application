package com.crud.peopleweb.controller;

import com.crud.peopleweb.dao.PeopleRepository;
import com.crud.peopleweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return peopleRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson(){
        return new Person();
    }

    @GetMapping
    public String showPeople(){
        return "people";
    }

    @PostMapping
    public String save(Person person){
        System.out.println(person);
        peopleRepository.save(person);
        return "redirect:people";
    }
}
