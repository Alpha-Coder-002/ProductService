package com.project.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="Orders")
public class Order extends BaseModel{

    @ManyToMany
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "Order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;
}
