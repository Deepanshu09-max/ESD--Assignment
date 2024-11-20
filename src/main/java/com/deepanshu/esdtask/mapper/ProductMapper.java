package com.deepanshu.esdtask.mapper;

import com.deepanshu.esdtask.dto.ProductReq;
import com.deepanshu.esdtask.entity.product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public product toproduct(ProductReq request) {
        return product.builder()
                .price(request.price())
                .name(request.name())
                .build();

    }
}
