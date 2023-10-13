package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.models.Customer;

import java.util.List;
import java.util.Optional;


public class CustomerRepository {

    private EntityManager em;
    private EntityTransaction trans;

    public CustomerRepository() {
        em = Persistence
                .createEntityManagerFactory("default")
                .createEntityManager();
        trans = em.getTransaction();

    }
    public List<Customer> getAllCustomers() {
        return em.createNamedQuery("Customer.findAll", Customer.class)
                .getResultList();

    }

    public Optional<Customer> getCustomerById(long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.custId =: id", Customer.class);
        query.setParameter("id", id);
        Customer cust = query.getSingleResult();
        return cust==null ? Optional.empty() : Optional.of(cust);
    }
    public void updateCustomer(Customer customer) {
        try {
            trans.begin();
            em.merge(customer);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public void insertCustomer(Customer customer) {
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public void deleteCustomer( long id) {
        try {
            Optional<Customer> op = getCustomerById(id);
            Customer c = op.get();
            trans.begin();
            em.remove(c);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
}
