package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Bronchiosaurus extends Dinosaur {
	private final double MOBILITY = 0.25;
	
	public Bronchiosaurus(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_NW"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_SW"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_NE"));	
		roomsInRange.add(getMap().get("BRONCHIOSAURUS_SE"));	
		roomsInRange.add(getMap().get("HALLWAY_3"));	
		roomsInRange.add(getMap().get("HALLWAY_4"));
		
		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
	}
	
	public String toString() {
		return super.toString("Bronchiosaurus");
	}
}
