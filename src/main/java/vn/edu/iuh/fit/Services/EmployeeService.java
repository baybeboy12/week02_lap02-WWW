package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(){
        employeeRepository = new EmployeeRepository();
    }
    public List<Employee> getAllEmp() {
        return employeeRepository.getAllEmployee();
    }
    public boolean insertEmp(Employee employee){
        employeeRepository.insertEmployee(employee);
        return true;
    }
    public boolean updateEmp(Employee employee){
        employeeRepository.updateEmployee(employee);
        return true;
    }
    public boolean deleteEmp(long id){
        employeeRepository.deleteEmployee(id);
        return true;
    }
    public boolean activeEmp(long id){
        employeeRepository.activeEmp(id);
        return true;
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.getEmployeeById(id);
    }
}
