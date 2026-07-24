package groupe2.service;


import groupe2.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void delete(Long id);
}