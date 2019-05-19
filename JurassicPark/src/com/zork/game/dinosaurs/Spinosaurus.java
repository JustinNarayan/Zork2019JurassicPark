package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Spinosaurus extends Dinosaur {
	
	public Spinosaurus(Room startRoom) {
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("SPINOSAURUS_SW"));	
		roomsInRange.add(getMap().get("SPINOSAURUS_NW"));	
		roomsInRange.add(getMap().get("SPINOSAURUS_NE"));	
		roomsInRange.add(getMap().get("HALLWAY_8"));	
		roomsInRange.add(getMap().get("HALLWAY_11"));	
		roomsInRange.add(getMap().get("BEACH_1_N"));	
		roomsInRange.add(getMap().get("BEACH_1_C"));	
		roomsInRange.add(getMap().get("BEACH_1_S"));	

		this.startRoom = startRoom;
		this.currentRoom = startRoom;
	}

	private HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}

	public String toString() {
		return super.toString("Spinosaurus");
	}
}
