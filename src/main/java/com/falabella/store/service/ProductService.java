package com.falabella.store.service;

import com.falabella.store.MiException.MiException;
import com.falabella.store.dto.MessageDto;
import com.falabella.store.dto.ProductDto;
import com.falabella.store.entity.Product;
import com.falabella.store.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Crear Producto
    public MessageDto createProduct(ProductDto productDto){
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(productDto,Product.class);
        productRepository.save(product);
        return new MessageDto("Product created");
    }

    //Read
    public List<ProductDto> listProducts(){
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = productRepository.findAll();
        List<ProductDto> productsDto = products.stream().map(product -> {
            return mapper.convertValue(product,ProductDto.class);
        }).collect(Collectors.toList());
        return productsDto;
    }

    //update
    public MessageDto updateProduct(Long id,ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
        }else {
            throw new  MiException("Producto no encontrado");
        }

        return new MessageDto("Producto actualizado");
    }

    //Delete
    public MessageDto deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            productRepository.delete(optionalProduct.get());
        }else{
            throw new  MiException("Producto no pudo eliminarse");
        }

        return new MessageDto("Producto eliminado");
    }

}
