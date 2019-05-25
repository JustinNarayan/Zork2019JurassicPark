package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Pterodactyl extends Dinosaur {
	private final double MOBILITY = 1;
	
	public Pterodactyl(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("PTERODACTYL_NW"));	
		roomsInRange.add(getMap().get("PTERODACTYL_SW"));	
		roomsInRange.add(getMap().get("PTERODACTYL_NE"));	
		roomsInRange.add(getMap().get("PTERODACTYL_SE"));	
		roomsInRange.add(getMap().get("PTERODACTYL_SE"));	
		roomsInRange.add(getMap().get("BRIDGE_S"));	
		roomsInRange.add(getMap().get("BRIDGE_C"));	
		roomsInRange.add(getMap().get("BRIDGE_N"));	
		
		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
	}

	public String toString() {
		return super.toString("Pterodactyl");
	}
}
