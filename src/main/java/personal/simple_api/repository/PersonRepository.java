package personal.simple_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.simple_api.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String Name);
}
