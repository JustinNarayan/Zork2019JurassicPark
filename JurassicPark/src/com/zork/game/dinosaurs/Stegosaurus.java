package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Stegosaurus extends Dinosaur {
	
	public Stegosaurus(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("STEGOSAURUS_NW"));	
		roomsInRange.add(getMap().get("STEGOSAURUS_SW"));	
		roomsInRange.add(getMap().get("STEGOSAURUS_NE"));	
		roomsInRange.add(getMap().get("STEGOSAURUS_SE"));	
		roomsInRange.add(getMap().get("HALLWAY_19"));	
		roomsInRange.add(getMap().get("HALLWAY_22"));	
		roomsInRange.add(getMap().get("HALLWAY_25"));	
		roomsInRange.add(getMap().get("LAKE"));	
		roomsInRange.add(getMap().get("RECORDS_W"));
		roomsInRange.add(getMap().get("RECORDS_E"));	
		roomsInRange.add(getMap().get("CLIFF_2_W"));	
		roomsInRange.add(getMap().get("CLIFF_2_E"));	
		
		this.currentRoom = startRoom;
		this.name = name;
	}

	public String toString() {
		return super.toString("Stegosaurus");
	}
}
