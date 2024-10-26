package vn.iuh.edu.fit.backend.business;

import vn.iuh.edu.fit.backend.repositories.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    void add(Product product);
    List<Product> findAll();
    Product findById(int id);
}
