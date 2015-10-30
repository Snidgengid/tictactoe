package is.ru.snidgengid.tictactoe;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.net.URI;
import java.net.URISyntaxException;


public class Database {
	public Database(){
	}

	public static String getBoard(String uuid) {
		Jedis conn = JedisFactory.getInstance().getJedisPool().getResource();
		try{
			String board = conn.get(uuid);
			return board;
		}
		catch (Exception e) {
			System.out.println(e);
			return "";
		}
		finally{
			JedisFactory.getInstance().getJedisPool().returnResource(conn);
		}
	}

	public static Boolean setBoard(String uuid, String board) {
		Jedis conn = JedisFactory.getInstance().getJedisPool().getResource();
		try{
			conn.set(uuid,board);
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
		finally{
			JedisFactory.getInstance().getJedisPool().returnResource(conn);
		}
	}

}