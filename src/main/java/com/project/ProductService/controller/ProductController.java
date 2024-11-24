package com.project.ProductService.controller;

import com.project.ProductService.dtos.GenericProductDto;
import com.project.ProductService.exceptions.ProductNotFoundException;
import com.project.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;


    ProductController(ProductService productService){
        this.productService=productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping("/getAllProducts")
    public List<GenericProductDto> getAllTheProducts(){
    return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
     public GenericProductDto deleteProductById(@PathVariable("id")Long id){
   return  productService.deleteProductById(id);
     }

     @PostMapping
     public void creteProduct(@RequestBody GenericProductDto genericProductDto){
     productService.creteProduct(genericProductDto);
     }
     public void updateProductById(){

     }

//     @ExceptionHandler(ProductNotFoundException.class)
//     public ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto=new ExceptionDto();
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//System.out.println("Got product not found exception");
//         return exceptionDto;
//     }
}
