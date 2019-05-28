package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Formatter;
import com.zork.game.Game;
import com.zork.game.Room;

public class Spinosaurus extends Dinosaur {
	private final double MOBILITY = 0.5;
	private final double AWARENESS = 0.7;
	private final int TURN_TO_KILL = 3;
	
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
		turnToKill = TURN_TO_KILL;
		invincible = false;
		canAttackInTree = false;
		carnivore = true;
	}
	
	public void killPlayer() {
		System.out.println(Formatter.blockText("The Spinosaurus has pinned you to the ground and devoured you appendage "
				+ "by appendage. You did not have a fun time.", Formatter.getCutoff(),""));
		super.killPlayer();
	}

	public String toString() {
		return super.toString("Spinosaurus");
	}
}
