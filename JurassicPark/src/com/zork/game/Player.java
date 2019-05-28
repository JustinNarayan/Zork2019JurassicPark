package com.zork.game;

import java.io.BufferedInputStream;
import java.util.ArrayList;

public class Player {
	public Inventory inventory;
	public boolean inTree;
	private boolean dead;
	private boolean success;

    public Player(BufferedInputStream bis){
        inventory = new Inventory();
        dead = false;
        inTree = false;
        success = false;
    }
    
    public Player() {
    	inventory = new Inventory();
        dead = false;
        inTree = false;
	}

	public Inventory getInventory(){
        return inventory;
    }

	public void equip(Item item) {
	}

	public void unequip(String secondWord) {
	}

	public void isInTree(boolean b) {
		inTree = b;
	}
	
	public void hasDied() {
		dead = true;
	}
	
	public boolean isDead() {
		return dead;
	}

	public int calculatePoints() {
		int points = 0;
		ArrayList<Item> temp = inventory.getInventoryItems();
		for(Item obj : temp) {
			if(obj instanceof Artifacts) points+=((Artifacts) obj).getPointsAmount();
		}
		return points;
	}
	
	public void gainSuccess() {
		success = true;
	}
	
	public boolean hasSucceeded() {
		return success;
	}


}
