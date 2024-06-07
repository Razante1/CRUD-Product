package exemplo.crud.crud.controllers;

import org.springframework.web.bind.annotation.RestController;

import exemplo.crud.crud.domain.product.Product;
import exemplo.crud.crud.domain.product.ProductRepository;
import exemplo.crud.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/product")
public class ProdutctController {
    
    @Autowired
    private ProductRepository repository;

    @SuppressWarnings("rawtypes")
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }


    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity postRequest(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        System.out.println(data);
        return ResponseEntity.ok("Conseguiu postar!");
        
    }
    @SuppressWarnings("rawtypes")
    @PutMapping
    public ResponseEntity putRequest(@RequestBody @Valid RequestProduct data) {
        Product product = repository.getReferenceById(data.id());
        product.setName(data.name());
        product.setPrice(data.price());
        repository.save(product);
        System.out.println(product);
        return ResponseEntity.ok().build();
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping
    public ResponseEntity deleteRequest(@RequestBody @Valid RequestProduct data) {
        repository.deleteById(data.id());
        return ResponseEntity.ok().build();
    }

    
}
