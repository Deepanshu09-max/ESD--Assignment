package com.deepanshu.esdtask.controller;

import com.deepanshu.esdtask.dto.ProductReq;
import com.deepanshu.esdtask.entity.product;
import com.deepanshu.esdtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/top2byprice")
    public List<product> getTop2ProductsByPriceRange() {
        return productService.getTop2ProductsByPriceRange();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductReq request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<?>> getProduct() {
        return ResponseEntity.ok(productService.getProduct());
    }

    @GetMapping("/{productid}")
    public ResponseEntity<?> getProductbyid(@PathVariable long productid) {
        return ResponseEntity.ok(productService.getProductById(productid));
    }

    @PutMapping("/{productid}")
    public ResponseEntity<?> updateProduct(@PathVariable long productid,@RequestBody ProductReq request) {
        return ResponseEntity.ok(productService.updateProduct(productid,request));
    }

    @DeleteMapping("/{productid}")
    public ResponseEntity<?> deleteProduct(@PathVariable long productid) {
        return ResponseEntity.ok(productService.deleteproduct(productid));
    }
}
