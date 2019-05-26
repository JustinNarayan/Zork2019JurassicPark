package com.zork.game;

public class Weapons extends Item {
    public boolean equipped;
    
    public Weapons(String name, Room room) {
    	this.name = name;
    	this.room = room;
    	this.environmentItem = null;
    	
    	state = "in room";
    }

    //constructor needs to be done

    public boolean isEquipped(){
        return equipped;        
    }
}