package is.ru.snidgengid.tictactoe;

import redis.clients.jedis.Jedis;

/**
* Implementation of Database abstraction layer for TicTacToe
*/
public class Database {
	/**
	* Constructor
	*/
	public Database(){
	}

	/**
	* Retrieves the associated JSON representation for a specified board from the Database
	* @param uuid Board UUID
	* @return String JSON representation of Board Class
	*/
	public static String getBoard(String uuid) {
		Jedis conn = JedisFactory.getInstance().getJedisPool().getResource();
		try {
			String board = conn.get(uuid);
			return board;
		} catch (Exception e) {
			System.out.println(e);
			return "";
		} finally {
			JedisFactory.getInstance().getJedisPool().returnResource(conn);
		}
	}

	/**
	* Saves the associated JSON representation for a specified board to the Database
	* @param uuid Board UUID
	* @param board Board JSON String
	* @return Boolean
	*/
	public static Boolean setBoard(String uuid, String board) {
		Jedis conn = JedisFactory.getInstance().getJedisPool().getResource();
		try {
			conn.set(uuid, board);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			JedisFactory.getInstance().getJedisPool().returnResource(conn);
		}
	}

}