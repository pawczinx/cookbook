package pawcio.spring.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pawcio.spring.commands.PersonForm;
import pawcio.spring.domain.Person;

@Component
public class PersonToPersonForm implements Converter<Person,PersonForm> {
    @Override
    public PersonForm convert(Person person) {
        PersonForm personForm = new PersonForm();
        personForm.setId(person.getId());
        personForm.setName(person.getName());
        personForm.setSurname(person.getSurname());
        personForm.setAge(person.getAge());
        return personForm;
    }
}
