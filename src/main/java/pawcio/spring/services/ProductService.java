package pawcio.spring.services;


import pawcio.spring.commands.ProductForm;
import pawcio.spring.domain.Product;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
