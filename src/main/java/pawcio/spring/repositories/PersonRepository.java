package pawcio.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import pawcio.spring.domain.Person;

public interface PersonRepository extends CrudRepository<Person,String> {
}
