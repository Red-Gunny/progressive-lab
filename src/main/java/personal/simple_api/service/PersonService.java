package personal.simple_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import personal.simple_api.dto.PersonResponse;
import personal.simple_api.entity.Person;
import personal.simple_api.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    public PersonResponse findPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return PersonResponse.builder()
                .age(person.getAge())
                .name(person.getName())
                .build();
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findPersonByName(String name) {
        List<Person> people = personRepository.findByName(name);
        List<PersonResponse> personResponseList = new ArrayList<>();
        for(Person p : people) {
            PersonResponse res = PersonResponse.builder()
                    .age(p.getAge())
                    .name(p.getName())
                    .build();
            personResponseList.add(res);
        }
        return personResponseList;
    }

    /**
    @Transactional(readOnly = true)
    public List<Person> findMZPerson(String name) {

    }

    @Transactional(readOnly = true)
    public List<Person> findMZPerson() {

    }**/

    public void savePerson(String name, int age) {
        personRepository.save(new Person(name, age));
    }

    public void update(String beforeName, String afterName) {

    }

    public void update(String name, int age) {
        List<Person> personList = personRepository.findByName(name);
        for(int i=0; i < personList.size(); i++) {
            Person p = personList.get(i);
        }
    }

}
