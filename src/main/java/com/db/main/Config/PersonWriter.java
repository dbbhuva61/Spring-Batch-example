package com.db.main.Config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.db.main.Repository.PersonRepository;
import com.db.main.entity.Person;

@Component
public class PersonWriter implements ItemWriter<Person>{
	
	private PersonRepository personRepository;

    @Autowired
    public PersonWriter (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Override
    public void write(List<? extends Person> persons) throws Exception{
        System.out.println("Data Saved for Users: " + persons);
        personRepository.saveAll(persons);
    }
}
