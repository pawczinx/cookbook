package pawcio.spring.repositories;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pawcio.spring.domain.Person;

public class PersonRepositoryTest {
    private static final Integer PERSON_AGE = 50;
    private static final String PERSON_NAME = "Dominik";
    private static final String PERSON_SURNAME = "KOWALSKI";

    @Autowired
    private PersonRepository personRepository;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Person person = new Person();
        person.setName(PERSON_NAME);
        person.setSurname(PERSON_SURNAME);
        person.setAge(PERSON_AGE);

        //when
//       personRepository.save(person);

        //then
        //Assert.assertNotNull(person.getId());
//        Person newPerson = personRepository.findById(person.getId()).orElse(null);
//        Assert.assertEquals(PERSON_NAME, newPerson.getName());
//        Assert.assertEquals(PERSON_SURNAME,newPerson.getSurname());
        //Assert.assertEquals(PERSON_AGE, newPerson.getAge());
    }
}