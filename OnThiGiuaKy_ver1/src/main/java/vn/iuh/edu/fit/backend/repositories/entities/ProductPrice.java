package vn.iuh.edu.fit.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "price_id", nullable = false)
    private Product product;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "apply_date", nullable = false)
    private Instant applyDate;

    @ColumnDefault("0")
    @Column(name = "value", nullable = false)
    private Double value;
    @Column(name = "note", length = 50)
    private String note;

    public ProductPrice(Integer id, Product product, Integer productId, Double value, Instant applyDate, String note) {
        this.id = id;
        this.product = product;
        this.productId = productId;
        this.value = value;
        this.applyDate = applyDate;
        this.note = note;
    }

    public ProductPrice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
