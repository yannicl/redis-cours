package com.yannicl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductClient {

    @Cacheable(value = "products", key = "'list'")
    public List<Product> getProductList() {
        ArrayList list = new ArrayList();

        list.add(new Product("1", "Gorilla Colle Super Glue liquide - 20 g", "8.48"));
        list.add(new Product("2", "Elmer's Colle transparente lavable pour école, flacon de 147 ml", "2.97"));
        list.add(new Product("3", "LePage Colle bois Express Quick Dry 150 ml", "6.97"));

        try {
            // service très couteux à appeler
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Product> getProductListWithoutCache() {
        return this.getProductList();
    }


}
