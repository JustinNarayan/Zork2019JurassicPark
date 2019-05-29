package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Formatter;
import com.zork.game.Game;
import com.zork.game.Room;

public class Pterodactyl extends Dinosaur {
	private final double MOBILITY = 1;
	private final double AWARENESS = 1;
	private final int TURN_TO_KILL = 2;
	
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
		awareness = AWARENESS;
		turnToKill = TURN_TO_KILL;
		invincible = false;
		canAttackInTree = true;
		carnivore = true;
	}
	
	public void killPlayer() {
		if(Game.getPlayer().inTree) System.out.println("Even in a tree, the dinosaur can still grab you!");
		System.out.println(Formatter.blockText("The Pterodactyl has swooped down and snatched you in its talons. You are brought to its nest and devoured "
				+ "by a group of ravenous dinosaurs. You are found bland and unappetizing at best.", Formatter.getCutoff(),""));
		super.killPlayer();
	}

	public String toString() {
		return super.toString("Pterodactyl");
	}
}
