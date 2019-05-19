package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Triceratops extends Dinosaur {
	
	public Triceratops(Room startRoom) {
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("TRICERATOPS_NW"));	
		roomsInRange.add(getMap().get("TRICERATOPS_SW"));	
		roomsInRange.add(getMap().get("TRICERATOPS_NE"));	
		roomsInRange.add(getMap().get("TRICERATOPS_SE"));	
		roomsInRange.add(getMap().get("HALLWAY_13"));	

		this.startRoom = startRoom;
		this.currentRoom = startRoom;
	}

	private HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}

	public String toString() {
		return super.toString("Triceratops");
	}
}
