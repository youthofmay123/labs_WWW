package vn.com.iuh.fit.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product", schema = "productdb")
@NamedQueries({
        @NamedQuery(name = "Product.findById", query = "select p from Product p where p.id = :id"),
        @NamedQuery(name = "Product.findAll", query = "select p from Product p")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Size(max = 250)
    @Column(name = "img_path", length = 250)
    private String imgPath;

    public Product() {
    }

    public Product(String name, String desc, String imgPath) {
        this.name = name;
        this.description = desc;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}