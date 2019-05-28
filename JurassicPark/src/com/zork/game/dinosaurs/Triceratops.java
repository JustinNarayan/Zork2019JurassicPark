package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class Triceratops extends Dinosaur {
	private final double MOBILITY = 0.5;
	private final double AWARENESS = 0;
	private final int TURN_TO_KILL = -1;
	
	public Triceratops(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("TRICERATOPS_NW"));	
		roomsInRange.add(getMap().get("TRICERATOPS_SW"));	
		roomsInRange.add(getMap().get("TRICERATOPS_NE"));	
		roomsInRange.add(getMap().get("TRICERATOPS_SE"));	
		roomsInRange.add(getMap().get("HALLWAY_13"));	
;
		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
		awareness = AWARENESS;
		turnToKill = TURN_TO_KILL;
		invincible = false;
	}

	public String toString() {
		return super.toString("Triceratops");
	}
}
