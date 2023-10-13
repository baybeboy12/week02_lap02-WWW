package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private double quantity;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Orders ordersByOrderId;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product productByProductId;

    public OrderDetail() {
    }

    public OrderDetail(String note, double price, double quantity, Orders ordersByOrderId, Product productByProductId) {
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.ordersByOrderId = ordersByOrderId;
        this.productByProductId = productByProductId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", ordersByOrderId=" + ordersByOrderId +
                ", productByProductId=" + productByProductId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(getOrdersByOrderId(), that.getOrdersByOrderId()) && Objects.equals(getProductByProductId(), that.getProductByProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrdersByOrderId(), getProductByProductId());
    }
}
