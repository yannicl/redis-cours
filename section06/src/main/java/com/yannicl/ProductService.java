package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductClient productClient;

    @Cacheable(value = "product", cacheManager = "alternateInMemoryCache")
    public Product getProduct(Integer id) {
        System.out.println("Fetching from the client the product id " + id);
        return productClient.getProductList().stream().filter(product -> product.getId().equals(id.toString())).findFirst().orElseThrow();
    }


}
