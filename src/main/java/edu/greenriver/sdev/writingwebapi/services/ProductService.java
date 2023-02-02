package edu.greenriver.sdev.writingwebapi.services;

import edu.greenriver.sdev.writingwebapi.exceptions.GeneralException;
import edu.greenriver.sdev.writingwebapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products= new ArrayList<>();
    public void addDemoProjects(){
        products.add(new Product(1, "demo", "this is demo", 12));
        products.add(new Product(2, "demo1", "this is demo1", 13));
        products.add(new Product(3, "demo2", "this is demo2", 14));
        products.add(new Product(4, "demo3", "this is demo3", 15));
    }

    public List<Product> getAllProducts(){return products; }
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product findProduct(int id) throws GeneralException {
        Product temp = products.stream()
                .filter(product -> id == product.getId())
                .findAny()
                .orElse(null);
        if(temp == null) {
            throw new GeneralException("Cannot find product");
        }
        return temp;
    }
    public Product deleteProduct(int id) throws GeneralException {
        Product product= findProduct(id);
        products.remove(product);
        return product;
    }
    public Product updateProduct(int id, Product product) throws GeneralException {
        Product saved = findProduct(id);
        products.remove(saved);








    }
}