package com.example.beproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons(){
		List<Person> persons = new ArrayList<>();
		personRepository.findAll()
		.forEach(persons::add);
		return persons;
	}
	
	public void addPerson(Person person){
		personRepository.save(person);
	}
	
	//Check if entered code exists in the database
	//returns boolean true or false if code exists or not
	public boolean checkCode(String code) {
		
		List<Person> persons = new ArrayList<>();
		personRepository.findAll()
		.forEach(persons::add);
		
		boolean result = false;
		
		for(Person person : persons) {
		      if(person.getGeneratedCode().equals(code)) {
		          result = true;
		      } else {
		    	  result = false;
		      }
		  }
		  
		  return result;
		  
	}
}
