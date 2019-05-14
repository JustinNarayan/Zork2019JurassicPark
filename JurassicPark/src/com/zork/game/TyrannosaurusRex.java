package com.zork.game;

import java.util.ArrayList;
import java.util.HashMap;

public class TyrannosaurusRex extends Dinosaur {
	
	public TyrannosaurusRex(Room startRoom) {
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("TREX_SW"));
		roomsInRange.add(getMap().get("TREX_SC"));
		roomsInRange.add(getMap().get("TREX_SE"));
		roomsInRange.add(getMap().get("TREX_NW"));
		roomsInRange.add(getMap().get("TREX_NC"));
		roomsInRange.add(getMap().get("TREX_NE"));
		
		this.startRoom = startRoom;
		this.currentRoom = startRoom;
	}

	private HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}

	public String toString() {
		return "Tyrannosaurus Rex";
	}
}
