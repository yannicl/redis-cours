package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("api/products")
    public Product getInfoProduit(@RequestParam(value = "productId") Integer productId) {
        return productService.getProduct(productId);
    }

}
