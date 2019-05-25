package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Velociraptor extends Dinosaur {
	private final double MOBILITY = 0.8;
	private final double AWARENESS = 0.8;
	
	public Velociraptor(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("VELOCIRAPTOR_NW"));	
		roomsInRange.add(getMap().get("VELOCIRAPTOR_SW"));	
		roomsInRange.add(getMap().get("VELOCIRAPTOR_NC"));	
		roomsInRange.add(getMap().get("VELOCIRAPTOR_SC"));	
		roomsInRange.add(getMap().get("VELOCIRAPTOR_NE"));	
		roomsInRange.add(getMap().get("HALLWAY_27"));	
		roomsInRange.add(getMap().get("HALLWAY_28"));	
		roomsInRange.add(getMap().get("HALLWAY_29"));	
		roomsInRange.add(getMap().get("HALLWAY_30"));	
		roomsInRange.add(getMap().get("CLIFF_1_SW"));	
		roomsInRange.add(getMap().get("CLIFF_1_SE"));	
		roomsInRange.add(getMap().get("JUNGLE_NW"));	
		roomsInRange.add(getMap().get("JUNGLE_SW"));
		roomsInRange.add(getMap().get("JUNGLE_NE"));
		roomsInRange.add(getMap().get("JUNGLE_SE"));
		roomsInRange.add(getMap().get("HILLS_NW"));
		roomsInRange.add(getMap().get("HILLS_SW"));
		roomsInRange.add(getMap().get("HILLS_NE"));
		roomsInRange.add(getMap().get("HILLS_SE"));
		roomsInRange.add(getMap().get("BREEDING_CENTRE_W"));
		roomsInRange.add(getMap().get("BREEDING_CENTRE_C"));
		roomsInRange.add(getMap().get("BREEDING_CENTRE_E"));
		
		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
		awareness = AWARENESS;
	}

	public String toString() {
		return super.toString("Velociraptor");
	}
}
