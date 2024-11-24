package com.project.ProductService.services;

import com.project.ProductService.dtos.FakeStoreProductDto;
import com.project.ProductService.dtos.GenericProductDto;
import com.project.ProductService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id) throws ProductNotFoundException;


    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto creteProduct(GenericProductDto genericProductDto);

    void updateProductById();


}