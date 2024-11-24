package com.project.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private String image;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(nullable = false)
    private Price price;
}
