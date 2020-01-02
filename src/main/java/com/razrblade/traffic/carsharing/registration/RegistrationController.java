package com.razrblade.traffic.carsharing.registration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razrblade.traffic.carsharing.model.HomoMobilis;
import com.razrblade.traffic.carsharing.model.PersonRepository;

@RestController
@RequestMapping("register")
public class RegistrationController {

	private PersonRepository personRepository;

	public RegistrationController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PostMapping("/")
	@CrossOrigin
	public ResponseEntity<PersonDTO> register(@RequestBody PersonDTO person) {
		if (personRepository.findByEmail(person.getEmail()).isPresent()) {
			return new ResponseEntity<PersonDTO>(HttpStatus.CONFLICT);
		}
		HomoMobilis homoMobilis = new HomoMobilis();
		homoMobilis.setFirstName(person.getFirstName());
		homoMobilis.setLastName(person.getLastName());
		homoMobilis.setEmail(person.getEmail());
		homoMobilis.setPhone(person.getPhone());
		homoMobilis.setOffice(person.getOffice());

		personRepository.save(homoMobilis);

		return new ResponseEntity<PersonDTO>(HttpStatus.OK);
	}

	@GetMapping("list")
	public List<PersonDTO> listPersons() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false).map(PersonDTO::new)
				.collect(Collectors.toList());
	}

}