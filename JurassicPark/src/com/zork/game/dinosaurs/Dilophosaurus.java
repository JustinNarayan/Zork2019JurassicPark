package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Formatter;
import com.zork.game.Game;
import com.zork.game.Room;

public class Dilophosaurus extends Dinosaur {
	private final double MOBILITY = 0.6;
	private final double AWARENESS = 0.6;
	private final int TURN_TO_KILL = 3;
	
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
		mobility = MOBILITY;
		awareness = AWARENESS;
		turnToKill = TURN_TO_KILL;
		invincible = false;
		canAttackInTree = false;
		carnivore = true;
	}
	
	public void killPlayer() {
		System.out.println(Formatter.blockText("The Dilophosaurus has spit acid and blinded you to make you easy prey. You are "
				+ "slowly and painfully eaten as the acid melts away your flesh. You have died.", Formatter.getCutoff(),""));
		super.killPlayer();
	}

	public String toString() {
		return super.toString("Dilophosaurus");
	}
}
