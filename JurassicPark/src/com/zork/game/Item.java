package com.zork.game;

import com.zork.game.dinosaurs.Dinosaur;

public abstract class Item {
	protected String state;
	protected Room room;
	protected EnvironmentItem environmentItem;
	protected String name;
	
	public Item() {
		//To be made
	}

	public String getName(){
		return name;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
		if(room!=null) this.room.getRoomInventory().addRoomItem(this);
	}
	
	public void setEnvironmentItem(EnvironmentItem env) {
		this.environmentItem = env;
	}
	
	public String getPoints() {
		return "";
	}
	
	public String getNameLowerCase() {
		return name.substring(0,1).toLowerCase() + name.substring(1);
	}
	
	public boolean use(Dinosaur dinosaur) {
		System.out.println("You cannot use this item in that way! Try a different command.");
		return false;
	}
	
	public String toString() {
		return getName();
	}
}
