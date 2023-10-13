package vn.edu.iuh.fit.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.EmployeeRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        List<Product> list = productRepository.getAllProd();
        for (Product p : list
        ){
        System.out.println(p);
        }
    }
}
