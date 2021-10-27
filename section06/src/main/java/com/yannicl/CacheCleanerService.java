package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class CacheCleanerService implements MessageListener {

    @Autowired
    @Qualifier("alternateInMemoryCache")
    CacheManager cacheManager;


    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message received: " + new String(message.getBody()));

        cacheManager.getCache("product").clear();

        System.out.println("I cleaned the cache");
    }

}
