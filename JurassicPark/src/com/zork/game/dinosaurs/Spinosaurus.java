package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Spinosaurus extends Dinosaur {
	private final double MOBILITY = 0.5;
	private final double AWARENESS = 0.3;
	
	public Spinosaurus(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("SPINOSAURUS_SW"));	
		roomsInRange.add(getMap().get("SPINOSAURUS_NW"));	
		roomsInRange.add(getMap().get("SPINOSAURUS_NE"));	
		roomsInRange.add(getMap().get("HALLWAY_8"));	
		roomsInRange.add(getMap().get("HALLWAY_11"));	
		roomsInRange.add(getMap().get("BEACH_1_N"));	
		roomsInRange.add(getMap().get("BEACH_1_C"));	
		roomsInRange.add(getMap().get("BEACH_1_S"));	

		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
		awareness = AWARENESS;
	}

	public String toString() {
		return super.toString("Spinosaurus");
	}
}
