package pawcio.spring.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pawcio.spring.commands.ProductForm;
import pawcio.spring.domain.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setName(product.getName());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
