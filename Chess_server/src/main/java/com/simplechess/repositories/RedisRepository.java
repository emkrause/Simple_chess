package com.simplechess.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * Example Jedis implementation.
 * Just to have a base
 */
public class RedisRepository {
    private static final Logger logger = LoggerFactory.getLogger(RedisRepository.class);

    JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public RedisRepository() {
        logger.debug("hello try");
    }

    public void TestJedisConnection() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");

            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
//		pool.destroy();
    }
}
