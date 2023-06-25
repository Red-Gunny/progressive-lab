package personal.simple_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.simple_api.service.PersonService;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/normal-person")
    public ResponseEntity<String> savePerson(String name, int age) {
        personService.savePerson(name, age);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
