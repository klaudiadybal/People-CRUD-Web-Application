package com.crud.peopleweb.data;

import com.crud.peopleweb.dao.PeopleRepository;
import com.crud.peopleweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    PeopleRepository peopleRepository;

    @Autowired
    public DataLoader(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(peopleRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "John", "Smith","john@spring.com", LocalDate.of(1997, 12, 17), new BigDecimal("4500")),
                    new Person(null, "Mary", "Johnson","mary@spring.com", LocalDate.of(1985, 2, 14), new BigDecimal("5000")),
                    new Person(null, "Dan", "Jones", "dan@spring.com", LocalDate.of(2000, 5, 15), new BigDecimal("4000")),
                    new Person(null, "Jennifer", "Jackson","jennifer@spring.com", LocalDate.of(1995, 7, 5), new BigDecimal("5500")),
                    new Person(null, "Bella", "Williams","bella@spring.com", LocalDate.of(2001, 6, 10), new BigDecimal("6000")));

            peopleRepository.saveAll(people);
        }


    }

}
