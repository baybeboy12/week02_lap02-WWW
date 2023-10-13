package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NamedQuery( name = "Customer.findAll",query = "FROM Customer")
public class Customer {
    @Id
    @Column(name = "cust_id", length = 20)
    private long custId;

    @Column(name = "address",length = 255)
    private String address;

    @Column(name = "email",length = 255)
    private String email;

    @Column(name = "cust_name",length = 255)
    private String custName;

    @Column(name = "phone",length = 15)
    private String phone;
    @OneToMany(mappedBy = "customerByCustId")
    private List<Orders> ordersByCustId;


    public Customer(long custId, String address, String email, String custName, String phone) {
        this.custId = custId;
        this.address = address;
        this.email = email;
        this.custName = custName;
        this.phone = phone;
    }

    public Customer() {
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", custName='" + custName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
