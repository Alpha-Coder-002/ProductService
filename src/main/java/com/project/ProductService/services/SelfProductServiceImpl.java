package com.project.ProductService.services;

import com.project.ProductService.dtos.FakeStoreProductDto;
import com.project.ProductService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
  return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
return null;
    }

    @Override
    public GenericProductDto creteProduct(GenericProductDto genericProductDto) {
return  null;
    }

    @Override
    public void updateProductById() {

    }
}
