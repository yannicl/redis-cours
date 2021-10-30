package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisZSet;
import org.springframework.data.redis.support.collections.RedisZSet;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceList {

    private RedisZSet<Product> pricelist;

    @Autowired
    public ProductPriceList(RedisTemplate<String, Product> redisTemplate) {
        pricelist = new DefaultRedisZSet<Product>("product-price-list", redisTemplate);

        add(new Product("1", "Gorilla Colle Super Glue liquide - 20 g", "8.48"));
        add(new Product("2", "Elmer's Colle transparente lavable pour école, flacon de 147 ml", "2.97"));
        add(new Product("3", "LePage Colle bois Express Quick Dry 150 ml", "6.97"));
    }

    public void clear() {
        pricelist.clear();
    }

    public void add(Product product) {
        pricelist.add(product, Double.parseDouble(product.getPrice()));
    }

    public int count() {
        return pricelist.size();
    }

    public Product cheapest() {
        return pricelist.first();
    }

    public Product mostExpensive() {
        return pricelist.last();
    }

}
