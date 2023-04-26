package com.kgisl.AngularCrud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "Products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    private double price;

    public Product() {
    }

    public Product(Long id, @NotBlank(message = "Name is required") String name, String description,
            @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01") double d) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = d;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
    }
    
    
}

