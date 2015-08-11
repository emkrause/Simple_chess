package com.simplechess.repositories;

import com.simplechess.dto.Chess_client;
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

    private static final String CLUSTER_NAME = "logcluster";
    private static final String TEST_SEARCH = "localtestsearch";
    private static final String LOCATION = "localhost";
    private static final int PORT = 9300;

    private final JedisPool pool;
    private final Jedis jedis;

//    private RedisTemplate<String, Chess_client> redisTemplate;

    public RedisRepository() {
        pool = new JedisPool(new JedisPoolConfig(), LOCATION);
        jedis = pool.getResource();
    }
//
//    public void testSession(Chess_client client) {
//        if (lookupSession(client)) {
//            getSession(client);
//            // validate sessiontime
//            // etc etc check;
//        }
//        else {
//            client.setSessionKey(makeNewSessionKey(client);
//            storeNewSession(client);
//        }
//    }
//
//    private String makeNewSessionKey(Chess_client client ) {
//        return "session"+client.getName();
//    }
//
//    private boolean lookupSession(Chess_client client ) {
//        return jedis.hasKey(client.getSessionKey());
//    }
//
//    private Chess_client getSession(Chess_client client ) {
//        return (Chess_client) jedis.get(client.getSessionKey());
//    }
//
//    private void storeNewSession(Chess_client client ) {
//        jedis.set(client.getSessionKey(), client);
//    }

}
