package com.db.main.Config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.db.main.entity.Person;



@Component
public class PersonProcessor implements ItemProcessor<Person,Person> {
	@Override
	public Person process(Person person) throws Exception {
		// TODO Auto-generated method stub   
		return person;
	}
}
