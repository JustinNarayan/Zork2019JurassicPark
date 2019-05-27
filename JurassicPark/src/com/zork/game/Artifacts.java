package com.zork.game;

public class Artifacts extends Item {
	private int points;
	private String read;
	private static String dinosaurInfo;
	
    public Artifacts(String name, String read, int points, Room room, EnvironmentItem environmentItem) {
    	this.name = name;
    	this.read = read;
    	this.points = points;
    	this.room = room;
    	this.environmentItem = environmentItem;
    	
    	if(environmentItem!=null) {
    		state="in "+environmentItem;
    		this.environmentItem.addItem(this);
    	}
    	else {
    		state="in room";
    		this.room.getRoomInventory().addRoomItem(this);
    	}
    }
    
    public static String getDinosaurInfo() {
    	return dinosaurInfo;
    }
}