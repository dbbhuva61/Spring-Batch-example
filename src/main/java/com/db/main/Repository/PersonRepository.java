package com.db.main.Repository;

import org.springframework.data.repository.CrudRepository;
import com.db.main.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

}
