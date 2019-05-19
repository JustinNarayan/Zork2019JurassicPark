package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Bronchiosaurus extends Dinosaur {
	
	public Bronchiosaurus(Room startRoom) {
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_NW"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_SW"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_NE"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_SE"));	
		roomsInRange.add(getMap().get("HALLWAY_3"));	
		roomsInRange.add(getMap().get("HALLWAY_4"));	
		this.startRoom = startRoom;
		this.currentRoom = startRoom;
	}

	private HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}

	public String toString() {
		return "Bronchiosaurus";
	}
}
