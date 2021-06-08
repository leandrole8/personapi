package com.leandroreis.personapi.service;

import com.leandroreis.personapi.dto.MessageResponseDTO;
import com.leandroreis.personapi.dto.request.PersonDTO;
import com.leandroreis.personapi.entity.Person;
import com.leandroreis.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        
        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID " + savedPerson.getId())
                .build();
    }
}
