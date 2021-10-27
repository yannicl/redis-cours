package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.integration.support.leader.LockRegistryLeaderInitiator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderService {

    @Autowired
    LockRegistryLeaderInitiator lockRegistryLeaderInitiator;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    ProductClient productClient;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;



    public boolean isLeader() {
        return lockRegistryLeaderInitiator.getContext().isLeader();
    }

    @Scheduled(fixedDelay = 10000L)
    public void performLeaderJob() {
        if (isLeader()) {
            System.out.println("I'm performing the leader job ;) !");

            List<Product> productList = productClient.getProductListWithoutCache();
            cacheManager.getCache("products").put("list", productList);

            redisTemplate.convertAndSend(topic.getTopic(), "refresh your cache!!");

            System.out.println("done !");

        } else {
            System.out.println("No leadership job for me ;( !");
        }
    }

}
