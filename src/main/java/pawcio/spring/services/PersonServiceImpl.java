package pawcio.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawcio.spring.commands.PersonForm;
import pawcio.spring.converters.PersonFormToPerson;
import pawcio.spring.domain.Person;
import pawcio.spring.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonFormToPerson personFormToPerson;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonFormToPerson personFormToPerson) {
        this.personRepository = personRepository;
        this.personFormToPerson = personFormToPerson;
    }



    @Override
    public List<Person> listAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public Person getById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person saveOrUpdate(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public void delete(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person saveOrUpdatePersonForm(PersonForm personForm) {
        Person savedPerson = saveOrUpdate(personFormToPerson.convert(personForm));
        System.out.println("Saved Person Id:" +savedPerson.getId());
        return savedPerson;
    }
}
