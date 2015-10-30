package is.ru.snidgengid.tictactoe;

import java.util.Arrays;
import java.util.UUID;


public class GameAction {
	private String uuid;
	private int xCoord;
	private int yCoord;

	public GameAction(){
		this.uuid = "";
		this.xCoord = -1;
		this.yCoord = -1;
	}

	public String getUUID(){
		return this.uuid;
	}
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}

	public int getXCoord(){
		return this.xCoord;
	}

	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getYCoord(){
		return this.yCoord;
	}

	public void setYCoord(int yCoord){
		this.yCoord = yCoord;
	}

}