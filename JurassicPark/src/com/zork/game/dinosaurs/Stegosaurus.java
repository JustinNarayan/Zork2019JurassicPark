package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Formatter;
import com.zork.game.Game;
import com.zork.game.Room;

public class Stegosaurus extends Dinosaur {
	private final double MOBILITY = 0.4;
	private final double AWARENESS = 0;
	private final int TURN_TO_KILL = -1;
	
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
		mobility = MOBILITY;
		awareness = AWARENESS;
		turnToKill = TURN_TO_KILL;
		invincible = false;
		canAttackInTree = true;
		carnivore = false;
	}
	
	public void killPlayer() {
		System.out.println(Formatter.blockText("The Stegosaurus has become enraged with your assaults and has whipped you to the floor "
				+ "violently with its tail. You have died.", Formatter.getCutoff(),""));
		super.killPlayer();
	}

	public String toString() {
		return super.toString("Stegosaurus");
	}
}
