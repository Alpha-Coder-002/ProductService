package com.project.ProductService.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "generator_name")
    @GenericGenerator(name="generator_name", strategy = "uuid2")
    @Column(name = "id",columnDefinition = "binary(16)", nullable = false)
    private UUID id;
}
