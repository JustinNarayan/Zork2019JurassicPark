package com.zork.game;

public class Item {
	private String type;
	private String state;
	private Room room;
	private EnvironmentItem environmentItem;
	public String name;
	
	public Item() {
		//To be made
	}
	
	public Item(String type, String state, EnvironmentItem environmentItem) {
		
	}

	public String getName(){
		return name;
	}
}
