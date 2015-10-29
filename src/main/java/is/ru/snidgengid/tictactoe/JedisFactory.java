package is.ru.snidgengid.tictactoe;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.net.URI;
import java.net.URISyntaxException;

class JedisFactory {
  private static JedisFactory instance = null;
  private static JedisPool jedisPool;
  public JedisFactory() {
    try{
      URI redisURI = null;
      if (System.getenv("REDIS_URL") != null){
        redisURI = new URI(System.getenv("REDIS_URL"));
      }
      else {
        redisURI = new URI("redis://localhost:6379");
      }
      JedisPoolConfig poolConfig = new JedisPoolConfig();
      poolConfig.setMaxTotal(20);
      jedisPool = new JedisPool(
       poolConfig, 
       redisURI
       );
    }
    catch (URISyntaxException e) {
      System.out.println("");
    }
  }

  public JedisPool getJedisPool() {
   return jedisPool;
 }

 public static JedisFactory getInstance() {
  if (instance == null) {
    instance = new JedisFactory();
  }
  return instance;
}
}