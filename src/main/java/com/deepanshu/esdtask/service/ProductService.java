package com.deepanshu.esdtask.service;

import com.deepanshu.esdtask.dto.ProductReq;
import com.deepanshu.esdtask.entity.product;
import com.deepanshu.esdtask.mapper.ProductMapper;
import com.deepanshu.esdtask.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepo productrepo;
    private final ProductMapper productMapper;

    public List<product> getTop2ProductsByPriceRange() {
        return productrepo.findTop2ProductsByPriceRange();
    }


    public String createProduct(ProductReq request) {
        product product = productMapper.toproduct(request);
        productrepo.save(product);
        return "product Created Successfully";
    }

    public List<?> getProduct() {
        return productrepo.findAll();
    }

    public Object getProductById(long productid) {
        return productrepo.findById(productid);
    }

    public Object updateProduct(long productid,ProductReq request) {
        product curr=productrepo.findById(productid).get();
        if(request.name()!=null){
            curr.setName(request.name());
        }
        if(request.price()!=0){
            curr.setPrice(request.price());
        }
        productrepo.save(curr);
        return "Product Updated Successfully";
    }

    public Object deleteproduct(long productid) {
        productrepo.deleteById(productid);
        return "Product Deleted Successfully";
    }
}
