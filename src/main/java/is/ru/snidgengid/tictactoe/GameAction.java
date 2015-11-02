package is.ru.snidgengid.tictactoe;

/**
* Implementation of GameAction object
**/
public class GameAction {
	private String uuid;
	private int xCoord;
	private int yCoord;

	/**
	* Constructor, initialized with invalid game action x and y coordinates
	**/
	public GameAction() {
		this.uuid = "";
		this.xCoord = -1;
		this.yCoord = -1;
	}

	/**
	* Get UUID
	* @return uuid String
	**/
	public String getUUID() {
		return this.uuid;
	}

	/**
	* Set UUID
	* @param uuid String UUID
	**/
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}

	/**
	* Get X coordinate (row)
	* @return xCoord int
	**/
	public int getXCoord() {
		return this.xCoord;
	}

	/**
	* Set X coordinate
	* @param xCoord int X Coordinate
	**/
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	/**
	* Get Y coordinate (row)
	* @return yCoord int
	**/
	public int getYCoord() {
		return this.yCoord;
	}

	/**
	* Set Y coordinate
	* @param yCoord int Y Coordinate
	**/
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}

}