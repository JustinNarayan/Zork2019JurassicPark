package com.zork.game;

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
		this.room.getRoomInventory().addRoomItem(this);
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
	
	public String toString() {
		return getName();
	}
}
