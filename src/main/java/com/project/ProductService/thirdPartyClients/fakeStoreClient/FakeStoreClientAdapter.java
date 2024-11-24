package com.project.ProductService.thirdPartyClients.fakeStoreClient;

import com.project.ProductService.dtos.FakeStoreProductDto;
import com.project.ProductService.dtos.GenericProductDto;
import com.project.ProductService.exceptions.ProductNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClientAdapter {
    private RestTemplateBuilder restTemplateBuilder;


    private String fakeStoreUrl;

    private String fakeStorePath;

    private  String specificProductUrl;
    private  String genericProductsUrl;

 //   alternative method
//    @PostConstruct
//    public void initUrls(){
//       specificProductUrl=fakeStoreUrl+fakeStorePath+"/{id}";
//      genericProductsUrl=fakeStoreUrl+fakeStorePath;
//    }


    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}")
    String fakeStoreUrl, @Value("${fakestore.api.path.products}") String fakeStorePath){
        this.restTemplateBuilder=restTemplateBuilder;
        this.specificProductUrl=fakeStoreUrl+fakeStorePath+"/{id}";
        this.genericProductsUrl=fakeStoreUrl+fakeStorePath;

    }



    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the fake store API
        //RestTemplate
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
        if(fakeStoreProductDto==null){
            //throw exception
            throw new ProductNotFoundException("Product with id: "+id+" doesn't exist" );
        }
        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        List<GenericProductDto> result=new ArrayList<>();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=restTemplate.getForEntity(genericProductsUrl,FakeStoreProductDto[].class);
        return List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return (responseEntity.getBody());
    }


    public FakeStoreProductDto creteProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(genericProductsUrl,genericProductDto,FakeStoreProductDto.class);
        return (responseEntity.getBody());
    }


    public void updateProductById() {

    }
}
