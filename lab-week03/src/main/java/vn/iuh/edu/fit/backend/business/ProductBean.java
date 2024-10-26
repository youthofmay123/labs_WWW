package vn.iuh.edu.fit.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import vn.iuh.edu.fit.backend.repositories.entities.Product;

import java.util.List;

@Stateless
public class ProductBean implements ProductBeanRemote {

    @PersistenceContext(unitName = "week03")
    private EntityManager entityManager;

    @Override
    @Consumes("application/json")
    @Produces("application/json")
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.createNamedQuery("Product.findById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
