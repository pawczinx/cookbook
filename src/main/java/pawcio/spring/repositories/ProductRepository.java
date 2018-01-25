package pawcio.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import pawcio.spring.domain.Product;


public interface ProductRepository extends CrudRepository<Product, String> {
}
