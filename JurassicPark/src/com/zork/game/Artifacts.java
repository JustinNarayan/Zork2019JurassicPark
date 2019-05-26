package com.zork.game;

public class Artifacts extends Item {
	private int points;
	
    public Artifacts(String name, int points, Room room, EnvironmentItem environmentItem) {
    	this.name = name;
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
}