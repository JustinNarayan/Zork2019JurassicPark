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
}
