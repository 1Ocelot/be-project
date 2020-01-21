package com.example.beproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@PostMapping(value="/persons/register", params = {"email","password"})
	public void addPerson(@RequestParam String email, @RequestParam String password) {
		Person person = new Person(email,password);
		personService.addPerson(person);
	}
	
	@PostMapping(value="/persons/register", params = {"email","password","code"})
	public void addPerson(@RequestParam String email, @RequestParam String password, @RequestParam String code) {
		
		personService.checkCode(code);
		
		Person person = new Person(email,password);
		
		if(personService.checkCode(code)) {
			person.setHasDiscount(true);
		}
		
		personService.addPerson(person);
	}
}
