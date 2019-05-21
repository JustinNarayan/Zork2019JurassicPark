package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Dilophosaurus extends Dinosaur {
	
	public Dilophosaurus(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("DILOPHOSAURUS_NW"));	
		roomsInRange.add(getMap().get("DILOPHOSAURUS_SW"));	
		roomsInRange.add(getMap().get("DILOPHOSAURUS_NE"));	
		roomsInRange.add(getMap().get("DILOPHOSAURUS_SE"));	
		roomsInRange.add(getMap().get("RIVER_1_SW"));	
		roomsInRange.add(getMap().get("RIVER_1_SE"));
		roomsInRange.add(getMap().get("RIVER_1_NE"));
		roomsInRange.add(getMap().get("HALLWAY_9"));
		roomsInRange.add(getMap().get("QUARRY_S"));
		roomsInRange.add(getMap().get("QUARRY_N"));

		this.currentRoom = startRoom;
		this.name = name;
	}

	public String toString() {
		return super.toString("Dilophosaurus");
	}
}
