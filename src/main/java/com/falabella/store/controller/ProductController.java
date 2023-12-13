package com.falabella.store.controller;

import com.falabella.store.dto.MessageDto;
import com.falabella.store.dto.ProductDto;
import com.falabella.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<MessageDto> createProduct(@RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> listProducts(){
        return new ResponseEntity<>(productService.listProducts(),HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<MessageDto> updateProduct( @PathVariable Long id, @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(id,productDto),HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<MessageDto> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }
}
