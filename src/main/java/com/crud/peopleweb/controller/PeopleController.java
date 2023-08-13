package com.crud.peopleweb.controller;

import com.crud.peopleweb.dao.PeopleRepository;
import com.crud.peopleweb.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String save(@Valid Person person, Errors errors){
        System.out.println(person);

        if(!errors.hasErrors()) {
            peopleRepository.save(person);
            return "redirect:people";
        }

        return "people";
    }

    @PostMapping(params = "delete=true")
    public String delete(@RequestParam Optional<List<Long>> toDelete){
        System.out.println(toDelete);
        if(toDelete.isPresent()){
            peopleRepository.deleteAllById(toDelete.get());
        }

        return "redirect:people";
    }
}
