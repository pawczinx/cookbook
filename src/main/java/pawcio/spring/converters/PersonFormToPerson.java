package pawcio.spring.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pawcio.spring.commands.PersonForm;
import pawcio.spring.domain.Person;

@Component
public class PersonFormToPerson implements Converter<PersonForm,Person> {
    @Override
         public Person convert(PersonForm personForm) {
            Person product = new Person();
            if (personForm.getId() != null  && !StringUtils.isEmpty(personForm.getId())) {
                product.setId(personForm.getId());
            }
            product.setName(personForm.getName());
            product.setSurname(personForm.getSurname());
            product.setAge(personForm.getAge());
            return product;
        }

}
