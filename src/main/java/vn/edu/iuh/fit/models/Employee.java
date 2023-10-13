package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "from Employee ")
public class Employee {
    @Id
    @Column(name = "emp_id",length = 20)
    private long empId;
    @Column(name = "address",length = 255)
    private String address;

    @Column(name = "dob",length = 6)
    private LocalDateTime dob;

    @Column(name = "email",length = 255)
    private String email;

    @Column(name = "full_name",length = 255)
    private String fullName;

    @Column(name = "phone",length = 15)
    private String phone;

    @Column(name = "status",columnDefinition = "INT",length =11)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employeeByEmpId")
    private List<Orders> ordersByEmpId;


    public Employee() {
    }

    public Employee(long empId, String address, LocalDateTime dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.empId = empId;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
