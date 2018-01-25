package pawcio.spring.services;

import pawcio.spring.commands.PersonForm;
import pawcio.spring.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person>listAll();
    Person getById(String id);
    Person saveOrUpdate(Person person);
    void delete(String id);
    Person saveOrUpdatePersonForm(PersonForm personForm);

}
