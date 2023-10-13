package vn.edu.iuh.fit.repositories;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository  {
    private EntityManager em;
    private EntityTransaction trans;
    public EmployeeRepository(){
        em = Persistence
                .createEntityManagerFactory("default")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public List<Employee> getAllEmployee(){
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.status = 1", Employee.class);
        List<Employee> list = query.getResultList();
        return list;
    }
    public Optional<Employee> getEmployeeById(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.empId =: id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        return employee==null ? Optional.empty() : Optional.of(employee);
    }
    public void updateEmployee(Employee employee) {
        try {
            trans.begin();
            em.merge(employee);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public void insertEmployee(Employee employee) {
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }
    }
    public boolean deleteEmployee( long id) {
        Optional<Employee> op = getEmployeeById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            deleteEmployeeDataBase(employee.getEmpId());
            return true;
        }
        return false;
    }
    public void deleteEmployeeDataBase(long id) {
        Optional<Employee> op = getEmployeeById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            if (employee.getStatus()== EmployeeStatus.TERMINATED){
                // Bắt đầu giao dịch
                em.getTransaction().begin();
                // Tạo truy vấn SQL cập nhật trạng thái của Employee
                String sql = "UPDATE Employee e SET e.status=-1 WHERE e.empid =:employeeId";
                Query query = em.createNativeQuery(sql);
                query.setParameter("employeeId",employee.getEmpId());
                query.executeUpdate();
                // Commit giao dịch
                em.getTransaction().commit();
            }
        }
    }
    public boolean activeEmp(long id) {
        Optional<Employee> op = getEmployeeById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }
}
