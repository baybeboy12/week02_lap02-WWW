package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }
    public List<Customer> getAllCus(){
        return customerRepository.getAllCustomers();
    }
    public boolean insertCus(Customer cus) {
        customerRepository.insertCustomer(cus);
        return true;
    }
    public boolean updateCus(Customer cus){
        customerRepository.updateCustomer(cus);
        return true;
    }
    public boolean deleteCus(long id){
        customerRepository.deleteCustomer(id);
        return true;
    }
    public Optional<Customer> findById(long id){
        return  customerRepository.getCustomerById(id);
    }
}
