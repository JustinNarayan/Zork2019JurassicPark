package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class TyrannosaurusRex extends Dinosaur {
	private final double MOBILITY = 0.65;
	
	public TyrannosaurusRex(Room startRoom, String name) {
		super(startRoom);
		roomsInRange = new ArrayList<Room>();
		roomsInRange.add(getMap().get("TREX_SW"));
		roomsInRange.add(getMap().get("TREX_SC"));
		roomsInRange.add(getMap().get("TREX_SE"));
		roomsInRange.add(getMap().get("TREX_NW"));
		roomsInRange.add(getMap().get("TREX_NC"));
		roomsInRange.add(getMap().get("TREX_NE"));
		roomsInRange.add(getMap().get("HALLWAY_20"));
		roomsInRange.add(getMap().get("HALLWAY_23"));
		roomsInRange.add(getMap().get("HALLWAY_24"));
		roomsInRange.add(getMap().get("CABIN"));
		roomsInRange.add(getMap().get("WATERFALL"));

		this.currentRoom = startRoom;
		this.name = name;
		mobility = MOBILITY;
	}

	public String toString() {
		return super.toString("TyrannosaurusRex");
	}
}
