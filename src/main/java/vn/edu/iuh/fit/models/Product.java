package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.convert.ProStatusConvert;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status=:status")
public class Product {

    @Id
    @Column(name = "product_id",length = 20)
    private long productId;

    @Column(name = "description",length = 250)
    private String description;

    @Column(name = "manufacturer_name",length = 100)
    private String manufacturerName;

    @Column(name = "name",length = 150)
    private String name;
    @Column(name = "status",columnDefinition = "INT",length = 11)
    private ProductStatus status;

    @Column(name = "unit")
    private String unit;
    @OneToMany(mappedBy = "productByProductId")
    private List<OrderDetail> orderDetailsByProductId;
    @OneToMany(mappedBy = "productByProductId")
    private List<ProductImage> productImagesByProductId;

    public Product() {
    }

    public Product(long productId, String description, String manufacturerName, String name, ProductStatus status, String unit) {
        this.productId = productId;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                '}';
    }
}
