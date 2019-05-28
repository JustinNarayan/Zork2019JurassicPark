package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Formatter;
import com.zork.game.Game;
import com.zork.game.Room;

public class TyrannosaurusRex extends Dinosaur {
	private final double MOBILITY = 0.65;
	private final double AWARENESS = 0.95;
	private final int TURN_TO_KILL = 2;
	private int isStunned = 0;
	
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
		awareness = AWARENESS;
		turnToKill = TURN_TO_KILL;
		invincible = true;
		canAttackInTree = true;
		carnivore = true;
		isStunned = 0;
	}
	
	public void killPlayer() {
		if(Game.getPlayer().inTree) System.out.println("Even in a tree, the dinosaur can still grab you!");
		System.out.println(Formatter.blockText("The Tyrannosaurus Rex has snatched you up and swallowed you whole. "
				+ "You have died an extremely painful death.", Formatter.getCutoff(),""));
		super.killPlayer();
	}

	public void becomeStunned() {
		isStunned = 2;
	}
	
	public void notStunned() {
		if(isStunned>0) isStunned--;
	}
	
	public void incrementTurn(DinosaurController c) {
		if(isStunned>0) return;
		super.incrementTurn();
	}
	
	public String toString() {
		return super.toString("Tyrannosaurus Rex");
	}
}
