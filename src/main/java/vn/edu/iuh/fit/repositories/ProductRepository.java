package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public ProductRepository(){
        em = Persistence
                .createEntityManagerFactory("default")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public List<Product> getAllProd(){
        TypedQuery<Product> query = em.createQuery("select p from Product p  where p.status = 1", Product.class);
        List<Product> list = query.getResultList();
        return list;
    }
    public Optional<Product> getProducteById(long id) {
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.productId =: id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        return product==null ? Optional.empty() : Optional.of(product);
    }
    public void updateProduct(Product product) {
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public void insertProduct(Product product) {
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public boolean deleteProduct( long id) {
        Optional<Product> op = getProducteById(id);
        if (op.isPresent()) {
            Product product = op.get();
            product.setStatus(ProductStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeProduct(long id) {
        Optional<Product> op = getProducteById(id);
        if (op.isPresent()) {
            Product product = op.get();
            product.setStatus(ProductStatus.ACTIVE);
            return true;
        }
        return false;
    }
}
