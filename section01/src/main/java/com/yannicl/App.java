package com.yannicl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String hostname = "192.168.0.157";
        int port = 6379;
        String password = null;

        JedisPoolConfig poolCfg = new JedisPoolConfig();
        poolCfg.setMaxTotal(3);

        JedisPool pool = new JedisPool(poolCfg, hostname, port, 500, password, false);
        try (Jedis jedis = pool.getResource()) {
            jedis.set("my-first-key", "Hello World!");
        }

    }
}
