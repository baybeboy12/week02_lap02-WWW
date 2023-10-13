package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id",length = 20)
    private long orderId;

    @Column(name = "order_date",length = 6)
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable = false)
    private Customer customerByCustId;
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", nullable = false)
    private Employee employeeByEmpId;
    @OneToMany(mappedBy = "ordersByOrderId")
    private List<OrderDetail> orderDetailsByOrderId;
    public Orders() {
    }

    public Orders(long orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                '}';
    }
}
