package com.project.ProductService.services;

import com.project.ProductService.dtos.FakeStoreProductDto;
import com.project.ProductService.dtos.GenericProductDto;
import com.project.ProductService.exceptions.ProductNotFoundException;
import com.project.ProductService.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class FakeStoreProductService implements ProductService{
    private FakeStoreClientAdapter fakeStoreAdapter;

    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter){
        this.fakeStoreAdapter=fakeStoreAdapter;
    }


    //convert fakeStoreProductDto to genericProductDto
    private static  GenericProductDto convertToGenericProductDto( FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the fake store API
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
   return fakeStoreAdapter.getAllProducts().stream().map(r->convertToGenericProductDto(r)).collect(Collectors.toList());
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
    return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto creteProduct(GenericProductDto genericProductDto) {
    return convertToGenericProductDto(fakeStoreAdapter.creteProduct(genericProductDto));
    }

    @Override
    public void updateProductById() {

    }

}
