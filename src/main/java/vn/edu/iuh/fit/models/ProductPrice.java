package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time",columnDefinition = "DATETIME")
    private LocalDateTime priceDateTime;

    @Column(name = "note",length = 255)
    private String note;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product productByProductId;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, String note, double price) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
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

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }
}
