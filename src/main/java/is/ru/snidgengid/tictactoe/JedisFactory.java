package is.ru.snidgengid.tictactoe;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.net.URI;
import java.net.URISyntaxException;

/**
  * Implements connection pooling for REDIS database
  */
class JedisFactory {
  private static JedisFactory instance = null;
  private static JedisPool jedisPool;
  /**
  * Constuctor that initializes connection pool for REDIS
  * @throws URISyntaxException
  */
  JedisFactory() {
    try {
      URI redisURI = null;
      if (System.getenv("REDIS_URL") != null) {
        redisURI = new URI(System.getenv("REDIS_URL"));
      } else {
        redisURI = new URI("redis://localhost:6379");
      }
      JedisPoolConfig poolConfig = new JedisPoolConfig();
      poolConfig.setMaxTotal(20);
      jedisPool = new JedisPool(
        poolConfig,
        redisURI
      );
    } catch (URISyntaxException e) {
      System.out.println("");
    }
  }

  /**
  * Returns the connection pool
  * @return JedisPool
  */
  public JedisPool getJedisPool() {
    return jedisPool;
  }

  /**
  * Returns instance of singleton JedisFactory class
  * @return JedisFactory
  */
  public static JedisFactory getInstance() {
    if (instance == null) {
      instance = new JedisFactory();
    }
    return instance;
  }
}