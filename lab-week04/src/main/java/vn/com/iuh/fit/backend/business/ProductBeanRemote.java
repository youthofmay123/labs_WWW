package vn.com.iuh.fit.backend.business;

import vn.com.iuh.fit.backend.repositories.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    void add(Product product);
    List<Product> findAll();
    Product findById(int id);
}
